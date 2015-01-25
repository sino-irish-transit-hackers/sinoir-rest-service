package com.sinoir.rest.service.mta.subway;

import com.sinoir.rest.CollectionUtils;
import com.sinoir.rest.FileUtils;
import com.sinoir.rest.models.gtfs.*;
import com.sinoir.rest.repositories.gtfs.*;
import org.apache.commons.io.FilenameUtils;
import org.jsefa.Deserializer;
import org.jsefa.common.lowlevel.filter.HeaderAndFooterFilter;
import org.jsefa.csv.CsvIOFactory;
import org.jsefa.csv.config.CsvConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@RestController
public class StaticDataController {
    private static List<String> CLAZZES = Arrays.asList("agency", "calendar", "calendar_dates", "routes", "shapes", "stops", "stop_times", "transfers", "trips");
    private static final Logger LOGGER = LoggerFactory.getLogger(StaticDataController.class);

    @Value("${mta.gtfs.static.subway.url}")
    private String url;

    @Autowired
    private AgencyRepo agency;
    @Autowired
    private CalendarDateRepo calendarDates;
    @Autowired
    private CalendarRepo calendars;
    @Autowired
    private RouteRepo routes;
    @Autowired
    private ShapeRepo shapes;
    @Autowired
    private StopRepo stops;
    @Autowired
    private StopTimeRepo stopTimes;
    @Autowired
    private TransferRepo transfers;
    @Autowired
    private TripRepo trips;

    private Map<String, Class<?>> getModels()
    {
        Map<String, Class<?>> models = new HashMap<>();
        for (Map.Entry<String, Class<?>> e : CollectionUtils.zip(CLAZZES, Arrays.asList(Agency.class, com.sinoir.rest.models.gtfs.Calendar.class, com.sinoir.rest.models.gtfs.CalendarDate.class, Route.class, Shape.class, Stop.class, StopTime.class, Transfer.class, Trip.class)))
            models.put(e.getKey(), e.getValue());

        return models;
    }

    private Map<String, Object> getRepos() {
        List<Object> repos = new ArrayList<>();
        repos.add(agency);
        repos.add(calendars);
        repos.add(calendarDates);
        repos.add(routes);
        repos.add(shapes);
        repos.add(stops);
        repos.add(stopTimes);
        repos.add(transfers);
        repos.add(trips);

        Map<String, Object> clazzes = new HashMap<>();
        for (Map.Entry<String, Object> e : CollectionUtils.zip(CLAZZES, repos))
            clazzes.put(e.getKey(), e.getValue());

        return clazzes;
    }

    @RequestMapping(value = "/mta/subway/static/{clazz}", method = RequestMethod.POST)
    public Response updateData(@PathVariable String clazz) throws IOException {
        Map<String, Class<?>> models = getModels();
        Map<String, Object> repos = getRepos();

        Set<String> clazzesToProcess = repos.keySet();
        if (!clazzesToProcess.contains(clazz) && !clazz.equals("*"))
            throw new IOException(String.format("Unknown class: '%s'", clazz));

        if (!clazz.equals("*")) {
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
                LOGGER.info("Processing file: '{}'", f.getAbsoluteFile());

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
                while (deserializer.hasNext()) {
                    objects.add(deserializer.next());
                }

                // save entities to database
                LOGGER.info("Updating class: '{}'", c);
                CrudRepository.class.cast(repos.get(c)).save(objects);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            org.apache.commons.io.FileUtils.deleteDirectory(outputDir);
        }

        return Response.status(200).entity(clazzesToProcess).build();
    }

    @RequestMapping(value = "/mta/subway/static/{clazz}", method = RequestMethod.DELETE)
    public Response clearData(@PathVariable String clazz) throws IOException {
        Map<String, Object> repos = getRepos();

        Set<String> clazzesToProcess = repos.keySet();
        if (!clazzesToProcess.contains(clazz) && !clazz.equals("*"))
            throw new IOException(String.format("Unknown class: '%s'", clazz));

        if (!clazz.equals("*")) {
            clazzesToProcess = new HashSet<>();
            clazzesToProcess.add(clazz);
        }

        for (String c : clazzesToProcess) {
            LOGGER.info("Clearing class: '{}'", c);
            CrudRepository.class.cast(repos.get(c)).deleteAll();
        }

        return Response.status(200).entity(clazzesToProcess).build();
    }
}
