package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Producer;
import com.codegym.laptopmanager.repository.ProducerRepository;
import com.codegym.laptopmanager.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducerServiceImpl implements IProducerService {
    @Autowired
    private ProducerRepository originRepository;

    @Override
    public Page<Producer> findAll(Pageable pageable) {
        return originRepository.findAll(pageable);
    }

    @Override
    public Optional<Producer> findById(Long id) {
        return originRepository.findById(id);
    }

    @Override
    public void save(Producer origin) {
        originRepository.save(origin);
    }

    @Override
    public void remote(Long id) {
        originRepository.deleteById(id);
    }
}
