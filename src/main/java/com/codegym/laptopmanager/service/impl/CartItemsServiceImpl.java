package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Origin;
import com.codegym.laptopmanager.service.ICartItemsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemsServiceImpl implements ICartItemsService {

    @Override
    public Page<CartItems> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<CartItems> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(CartItems cartItems) {

    }

    @Override
    public void remote(Long id) {

    }
}
