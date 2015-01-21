package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepo extends CrudRepository<Trip, String> {
}
