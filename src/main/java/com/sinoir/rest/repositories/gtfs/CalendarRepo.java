package com.sinoir.rest.repositories.gtfs;


import com.sinoir.rest.models.gtfs.Calendar;
import org.springframework.data.repository.CrudRepository;

public interface CalendarRepo extends CrudRepository<Calendar, String> {}
