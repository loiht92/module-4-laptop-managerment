package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Page<Customer> findAllByName(String name, Pageable pageable);
}
