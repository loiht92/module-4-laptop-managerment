package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ILaptopService {
    Page<Laptop> findAll(Pageable pageable);

    Optional<Laptop> findById(Long id);

    void save(Laptop laptop);

    void remote(Long id);
}
