package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.repository.LaptopRepository;
import com.codegym.laptopmanager.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaptopServiceImpl implements ILaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    @Override
    public Page<Laptop> findAll(Pageable pageable) {
        return laptopRepository.findAll(pageable);
    }

    @Override
    public Optional<Laptop> findById(Long id) {
        return laptopRepository.findById(id);
    }

    @Override
    public void save(Laptop laptop) {
        laptopRepository.save(laptop);
    }

    @Override
    public void remote(Long id) {
        laptopRepository.deleteById(id);
    }
}
