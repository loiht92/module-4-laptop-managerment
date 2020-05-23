package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.repository.CustomerRepository;
import com.codegym.laptopmanager.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByCustomerName(String name, Pageable pageable) {
        return customerRepository.findAllByName(name, pageable);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remote(Long id) {
        customerRepository.deleteById(id);
    }
}
