package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.service.ICustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remote(Long id) {

    }
}
