package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.service.ILaptopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopServiceImpl implements ILaptopService {
    @Override
    public Page<Laptop> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Laptop> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Laptop laptop) {

    }

    @Override
    public void remote(Long id) {

    }
}
