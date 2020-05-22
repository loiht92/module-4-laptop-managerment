package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Origin;

import java.util.Optional;

public interface ICartService {
    Iterable<Origin> findAll();

    Optional<Origin> findById(Long id);

    void save(Origin origin);

    void remote(Long id);
}
