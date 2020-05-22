package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOriginService {
    Page<Origin> findAll(Pageable pageable);

    Optional<Origin> findById(Long id);

    void save(Origin origin);

    void remote(Long id);
}
