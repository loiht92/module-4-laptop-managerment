package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Long> {
    Page<Orders> findAllByCustomerDates(String orders_date, Pageable pageable);

    Iterable<Orders> findAllByCustomer(Customer customer);

    //Orders findOrdersByCustomer(Customer customer);
}
