package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Agency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends CrudRepository<Agency, String> {}
