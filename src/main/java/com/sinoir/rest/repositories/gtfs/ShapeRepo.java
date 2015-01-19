package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Shape;
import org.springframework.data.repository.CrudRepository;

public interface ShapeRepo extends CrudRepository<Shape, Integer> {
}
