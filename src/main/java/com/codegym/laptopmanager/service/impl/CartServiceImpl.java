package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.service.ICartService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {
    @Override
    public Page<Cart> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public void remote(Long id) {

    }
}
