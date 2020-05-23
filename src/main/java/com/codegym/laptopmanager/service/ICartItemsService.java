package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICartItemsService {
    Page<CartItems> findAll(Pageable pageable);

    Optional<CartItems> findById(Long id);

    CartItems findByCartItemsAndLaptop(Cart cart, Laptop laptop);

    List<CartItems> findCartItemsByCart(Cart cart);

    List<CartItems> findCartItemByCart(Cart cart);

    void save(CartItems cartItems);

    void remote(Long id);
}
