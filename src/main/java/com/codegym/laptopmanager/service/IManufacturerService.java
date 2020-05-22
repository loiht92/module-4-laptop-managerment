package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Manufacturer;
import com.codegym.laptopmanager.model.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IManufacturerService {
    Page<Manufacturer> findAll(Pageable pageable);

    Optional<Manufacturer> findById(Long id);

    void save(Manufacturer manufacturer);

    void remote(Long id);
}
