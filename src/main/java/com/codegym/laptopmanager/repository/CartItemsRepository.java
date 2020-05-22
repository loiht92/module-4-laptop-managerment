package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends PagingAndSortingRepository<CartItems, Long> {
    List<CartItems> findCartItemsByCart(Cart cart);

    CartItems findCartItemsByCartAndLaptop(Cart cart, Laptop laptop);
}
