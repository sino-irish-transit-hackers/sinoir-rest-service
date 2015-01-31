package com.sinoir.rest.service.mta;

import com.sinoir.rest.models.gtfs.Shape;
import com.sinoir.rest.repositories.gtfs.ShapeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class ShapeController {
    @Autowired
    private ShapeRepo shapes;

    @RequestMapping(value = "/mta/shape/", method = RequestMethod.GET)
    public Iterable<Shape> getAllShapes() throws SQLException {
        return shapes.findAll();
    }

    @RequestMapping(value = "/mta/shape/{id}", method = RequestMethod.GET)
    public Iterable<Shape> getShape(@PathVariable String id) throws SQLException {
        return shapes.findByShapeId(id);
    }

    @RequestMapping(value = "/mta/shape/pk/{id}", method = RequestMethod.GET)
    public Shape getByKey(@PathVariable Integer id) throws SQLException {
        return shapes.findOne(id);
    }
}
