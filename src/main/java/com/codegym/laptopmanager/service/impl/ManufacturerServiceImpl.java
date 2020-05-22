package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Status;
import com.codegym.laptopmanager.repository.ManufacturerRepository;
import com.codegym.laptopmanager.service.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Page<Status> findAll(Pageable pageable) {
        return manufacturerRepository.findAll(pageable);
    }

    @Override
    public Optional<Status> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public void save(Status manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void remote(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
