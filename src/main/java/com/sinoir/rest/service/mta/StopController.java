package com.sinoir.rest.service.mta;

import com.sinoir.rest.models.gtfs.Stop;
import com.sinoir.rest.repositories.gtfs.StopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class StopController {
    @Autowired
    private StopRepo stops;

    @RequestMapping(value = "/mta/stop/", method = RequestMethod.GET)
    public Iterable<Stop> getAllStops() throws SQLException {
        return stops.findAll();
    }

    @RequestMapping(value = "/mta/stop/{id}", method = RequestMethod.GET)
    public Stop getStop(@PathVariable String id) throws SQLException {
        return stops.findOne(id);
    }
}
