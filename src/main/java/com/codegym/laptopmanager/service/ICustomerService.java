package com.codegym.laptopmanager.service;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remote(Long id);
}
