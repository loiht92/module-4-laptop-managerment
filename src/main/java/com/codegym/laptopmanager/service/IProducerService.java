package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Producer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IProducerService {
    Page<Producer> findAll(Pageable pageable);

    Page<Producer> findAllByName(String name , Pageable pageable);

    Optional<Producer> findById(Long id);

    void save(Producer producer);

    void remote(Long id);
}
