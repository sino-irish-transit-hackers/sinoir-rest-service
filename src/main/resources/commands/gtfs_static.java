package commands;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.sinoir.rest.CollectionUtils;
import com.sinoir.rest.models.gtfs.*;
import com.sinoir.rest.repositories.gtfs.*;
import com.sinoir.rest.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.crsh.cli.Argument;
import org.crsh.cli.Command;
import org.crsh.cli.Required;
import org.crsh.cli.Usage;
import org.crsh.cli.descriptor.ParameterDescriptor;
import org.crsh.cli.spi.Completer;
import org.crsh.cli.spi.Completion;
import org.crsh.command.BaseCommand;
import org.jsefa.Deserializer;
import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Usage("GTFS static data commands")
public class gtfs_static extends BaseCommand {
    private static List<String> CLAZZES = Arrays.asList("agency", "calendar", "calendar_dates", "routes", "shapes", "stops", "transfers", "trips");

    private static class ClazzCompleter implements Completer {
        @Override
        public Completion complete(ParameterDescriptor parameter, String prefix) throws Exception {
            Map<String, Boolean> suffixes = new HashMap<>();
            for (String c : Collections2.filter(CLAZZES, Predicates.containsPattern(String.format("^%s", prefix))))
                suffixes.put(c.substring(prefix.length()), true);
            return Completion.create(prefix, suffixes);
        }
    }

    private Map<String, Class<?>> getModels()
    {
        Map<String, Class<?>> models = new HashMap<>();
        for (Map.Entry<String, Class<?>> e : CollectionUtils.zip(CLAZZES, Arrays.asList(Agency.class, Calendar.class, CalendarDate.class, Route.class, Shape.class, Stop.class, StopTime.class, Transfer.class, Trip.class)))
            models.put(e.getKey(), e.getValue());

        return models;
    }

    private Map<String, Class<? extends CrudRepository>> getRepos() {
        List<Class<? extends CrudRepository>> repos = new ArrayList<>();
        repos.add(AgencyRepo.class);
        repos.add(CalendarRepo.class);
        repos.add(CalendarDateRepo.class);
        repos.add(RouteRepo.class);
        repos.add(ShapeRepo.class);
        repos.add(StopRepo.class);
        repos.add(StopTimeRepo.class);
        repos.add(TransferRepo.class);
        repos.add(TripRepo.class);

        Map<String, Class<? extends CrudRepository>> clazzes = new HashMap<>();
        for (Map.Entry<String, Class<? extends CrudRepository>> e : CollectionUtils.zip(CLAZZES, repos))
            clazzes.put(e.getKey(), e.getValue());

        return clazzes;
    }

    @Usage("download GTFS static data from url")
    @Command
    public void download(@Required @Argument @Usage("URL to GTFS static data") String url,
                         @Argument(completer = ClazzCompleter.class) @Usage("class name to download") String clazz) throws Exception {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");

        Map<String, Class<?>> models = getModels();
        Map<String, Class<? extends CrudRepository>> repos = getRepos();

        Set<String> clazzesToProcess = repos.keySet();
        if (clazz != null) {
            clazzesToProcess = new HashSet<>();
            clazzesToProcess.add(clazz);
        }

        File outputDir = new File(System.getProperty("java.io.tmpdir"), String.format("gtfs_static.%s", Long.toString(System.nanoTime())));
        try {
            URL url0 = new URL(url);
            String filename = FilenameUtils.getName(url);

            org.apache.commons.io.FileUtils.copyURLToFile(url0, new File(outputDir, filename));
            if (filename.endsWith(".zip"))
                FileUtils.unzip(new File(outputDir, filename).getAbsolutePath(), outputDir.getAbsolutePath());

            for (String c : clazzesToProcess) {
                File f = new File(outputDir, String.format("%s.txt", c));
                System.out.println(String.format("Processing file: %s", f.getAbsoluteFile()));

                // setup CSV reader configuration
                CsvConfiguration config = new CsvConfiguration();
                config.setFieldDelimiter(',');
                config.setLineFilter(new HeaderAndFooterFilter(1, false, false));

                // create CSV reader
                final Deserializer deserializer = CsvIOFactory.createFactory(config, models.get(c)).createDeserializer();
                FileReader reader = new FileReader(f);
                deserializer.open(reader);

                // read all records in CSV file
                List<Object> objects = new ArrayList<>();
                while (deserializer.hasNext())
                    objects.add(deserializer.next());

                // save entities to database
                beanFactory.getBean(repos.get(c)).save(objects);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            org.apache.commons.io.FileUtils.deleteDirectory(outputDir);
        }
    }

    @Usage("clear GTFS static data in database")
    @Command
    public void clear(@Argument String clazz) {
        BeanFactory beanFactory = (BeanFactory) context.getAttributes().get("spring.beanfactory");

        Map<String, Class<? extends CrudRepository>> repos = getRepos();
        Set<String> clazzesToProcess = repos.keySet();
        if (clazz != null) {
            clazzesToProcess = new HashSet<>();
            clazzesToProcess.add(clazz);
        }

        for (String c : clazzesToProcess)
            beanFactory.getBean(repos.get(c)).deleteAll();
    }
}
