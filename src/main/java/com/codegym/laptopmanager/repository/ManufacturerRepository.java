package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Manufacturer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends PagingAndSortingRepository<Manufacturer, Long> {
}
