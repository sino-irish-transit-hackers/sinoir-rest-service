package com.sinoir.rest.service.mta;

import com.sinoir.rest.models.gtfs.Route;
import com.sinoir.rest.repositories.gtfs.RouteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

@RestController
public class RouteController {
    @Autowired
    private RouteRepo routes;

    @RequestMapping(value = "/mta/route/", method = RequestMethod.GET)
    public Iterable<Route> getAllRoutes() throws SQLException {
        return routes.findAll();
        // return Response.status(201).entity("Successfully found route").build();
    }

    @RequestMapping(value = "/mta/route/{id}", method = RequestMethod.GET)
    public Route getRoute(@PathVariable String id) throws SQLException {
        return routes.findOne(id);
        // return Response.status(201).entity("Successfully found route").build();
    }
}
