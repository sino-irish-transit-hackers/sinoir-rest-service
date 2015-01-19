package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.CalendarDate;
import org.springframework.data.repository.CrudRepository;

public interface CalendarDateRepo extends CrudRepository<CalendarDate, Integer> {
}
