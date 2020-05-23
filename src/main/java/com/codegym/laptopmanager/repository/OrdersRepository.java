package com.codegym.laptopmanager.repository;

import com.codegym.laptopmanager.model.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends PagingAndSortingRepository<Orders, Long> {
    Page<Orders> findAllByCustomer_date_orders(String orders_date, Pageable pageable);
}
