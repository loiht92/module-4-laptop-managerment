package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.model.Origin;
import com.codegym.laptopmanager.repository.CartItemsRepository;
import com.codegym.laptopmanager.service.ICartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemsServiceImpl implements ICartItemsService {
    @Autowired
    private CartItemsRepository cartItemsRepository;

    @Override
    public Page<CartItems> findAll(Pageable pageable) {
        return cartItemsRepository.findAll(pageable);
    }

    @Override
    public Optional<CartItems> findById(Long id) {
        return cartItemsRepository.findById(id);
    }

    @Override
    public CartItems findByCartItemsAndLaptop(Cart cart, Laptop laptop) {
        return cartItemsRepository.findCartItemsByCartAndLaptop(cart, laptop);
    }

    @Override
    public List<CartItems> findCartItemsByCart(Cart cart) {
        return cartItemsRepository.findCartItemsByCart(cart);
    }

    @Override
    public List<CartItems> findCartItemByCart(Cart cart) {
        return cartItemsRepository.findCartItemsByCart(cart);
    }

    @Override
    public void save(CartItems cartItems) {
        cartItemsRepository.save(cartItems);
    }

    @Override
    public void remote(Long id) {
        cartItemsRepository.deleteById(id);
    }
}
