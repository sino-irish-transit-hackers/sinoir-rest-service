package com.sinoir.rest.repositories.gtfs;

import com.sinoir.rest.models.gtfs.Transfer;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepo extends CrudRepository<Transfer, String> {
}
