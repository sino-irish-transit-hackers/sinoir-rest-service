package com.sinoir.rest.service.mta.subway;

import com.google.transit.realtime.GtfsRealtime;
import com.sinoir.rest.models.gtfs.Route;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.sql.SQLException;

@RestController
public class RealTimeController {
    @Value("${mta.gtfs.realtime.subway.url}")
    private String url;

    @RequestMapping(value = "/mta/subway/update/{id}", method = RequestMethod.GET)
    public Response getUpdate(@PathVariable String id) throws IOException {
        URL website = new URL(String.format("%s&feed_id=%s", url, id));
        try(InputStream stream = website.openStream()) {
            GtfsRealtime.FeedMessage message = GtfsRealtime.FeedMessage.parseFrom(stream);
            return Response.status(201).entity(message.toString()).build();
        }

    }
}
