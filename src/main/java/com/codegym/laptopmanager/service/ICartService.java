package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICartService {
    Page<Laptop> findAllLaptop(Pageable pageable);

    List<CartItems> findAllCartItems();

    List<Cart> findAllCart();

    CartItems findCartItemsById(Long id);

    void removeCartItemsById(Long id);

    void saveCartItems(CartItems cartItems);

    void saveCart(Cart cart);

    Laptop findLaptopById(Long laptop_id);

    CartItems findCartItemByCartAndLaptop(Cart cart, Laptop laptop);

    List<CartItems> findCartItemsByCart(Cart cart);

    List<CartItems> findCartItemByCart(Cart cart);
}
