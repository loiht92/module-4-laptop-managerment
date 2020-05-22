package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
    List<Cart> findAllById(Long id);
}
