package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.StopTime;
import org.springframework.data.repository.CrudRepository;

public interface StopTimeRepo extends CrudRepository<StopTime, Integer> {
}
