package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Stop;
import org.springframework.data.repository.CrudRepository;

public interface StopRepo extends CrudRepository<Stop, String> {
}
