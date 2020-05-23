package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IStatusService {
    Page<Status> findAll(Pageable pageable);

    Optional<Status> findById(Long id);

    void save(Status manufacturer);

    void remote(Long id);
}
