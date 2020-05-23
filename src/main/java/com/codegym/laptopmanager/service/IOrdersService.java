package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IOrdersService {
    Page<Orders> findAll(Pageable pageable);

    Optional<Orders> findById(Long id);

    void save(Orders orders);

    void remote(Long id);
}
