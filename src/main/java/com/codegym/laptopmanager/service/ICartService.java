package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Cart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICartService {
    Page<Cart> findAll(Pageable pageable);

    Optional<Cart> findById(Long id);

    void save(Cart cart);

    void remote(Long id);
}
