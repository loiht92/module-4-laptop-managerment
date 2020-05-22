package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Origin;
import com.codegym.laptopmanager.repository.OriginRepository;
import com.codegym.laptopmanager.service.IOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OriginServiceImpl implements IOriginService {
    @Autowired
    private OriginRepository originRepository;

    @Override
    public Page<Origin> findAll(Pageable pageable) {
        return originRepository.findAll(pageable);
    }

    @Override
    public Optional<Origin> findById(Long id) {
        return originRepository.findById(id);
    }

    @Override
    public void save(Origin origin) {
        originRepository.save(origin);
    }

    @Override
    public void remote(Long id) {
        originRepository.deleteById(id);
    }
}
