package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICartItemsService {
    Page<CartItems> findAll(Pageable pageable);

    Optional<CartItems> findById(Long id);

    void save(CartItems cartItems);

    void remote(Long id);
}
