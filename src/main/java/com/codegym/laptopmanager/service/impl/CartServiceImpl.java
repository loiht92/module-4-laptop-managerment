package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.repository.CartItemsRepository;
import com.codegym.laptopmanager.repository.CartRepository;
import com.codegym.laptopmanager.repository.LaptopRepository;
import com.codegym.laptopmanager.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    CartItemsRepository cartItemRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    LaptopRepository laptopRepository;

    @Override
    public Page<Laptop> findAllLaptop(Pageable pageable) {
        return laptopRepository.findAll(pageable);
    }

    @Override
    public List<CartItems> findAllCartItems() {
        return (List<CartItems>) cartItemRepository.findAll();
    }

    @Override
    public List<Cart> findAllCart() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public CartItems findCartItemsById(Long id) {
        Optional<CartItems> cartItemsOption = cartItemRepository.findById(id);
        if (cartItemsOption.isPresent()){
            return cartItemsOption.get();
        }
        throw new RuntimeException("No find Cart");
    }

    @Override
    public void removeCartItemsById(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public void saveCartItems(CartItems cartItems) {
        cartItemRepository.save(cartItems);
    }

    @Override
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public Laptop findLaptopById(Long laptop_id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(laptop_id);
        if (laptopOptional.isPresent())
            return laptopOptional.get();
        throw new RuntimeException("Laptop not found");
    }

    @Override
    public CartItems findCartItemByCartAndLaptop(Cart cart, Laptop laptop) {
        return cartItemRepository.findCartItemsByCartAndLaptop(cart, laptop);
    }

    @Override
    public List<CartItems> findCartItemsByCart(Cart cart) {
        return cartItemRepository.findCartItemsByCart(cart);
    }

    @Override
    public List<CartItems> findCartItemByCart(Cart cart) {
        return cartItemRepository.findCartItemsByCart(cart);
    }
}
