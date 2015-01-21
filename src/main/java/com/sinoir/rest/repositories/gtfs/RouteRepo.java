package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Route;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RouteRepo extends CrudRepository<Route, String> {
    List<Route> findByRouteType(Integer routeType);
}
