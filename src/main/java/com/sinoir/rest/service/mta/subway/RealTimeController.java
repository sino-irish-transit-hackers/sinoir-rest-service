package com.sinoir.rest.service.mta.subway;

import com.google.transit.realtime.GtfsRealtime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@RestController
public class RealTimeController {
    @Value("${mta.gtfs.realtime.subway.url}")
    private String url;

    @RequestMapping(value = "/mta/subway/update/{id}", method = RequestMethod.GET)
    public Object getUpdate(@PathVariable String id, @RequestParam(value="format", defaultValue="proto") String format) throws IOException {
        URL website = new URL(String.format("%s&feed_id=%s", url, id));
        try(InputStream stream = website.openStream()) {
            GtfsRealtime.FeedMessage message = GtfsRealtime.FeedMessage.parseFrom(stream);
            return format.equals("proto") ? message.toByteArray() : message.toString();
        }
    }
}
