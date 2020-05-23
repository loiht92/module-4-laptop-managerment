package com.codegym.laptopmanager.service.impl;

import com.codegym.laptopmanager.model.Orders;
import com.codegym.laptopmanager.repository.OrdersRepository;
import com.codegym.laptopmanager.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Page<Orders> findAllByDateOrders(String orders_date, Pageable pageable) {
        return ordersRepository.findAllByCustomer_date_orders(orders_date, pageable);
    }


    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public void save(Orders orders) {
        ordersRepository.save(orders);
    }

    @Override
    public void remote(Long id) {
        ordersRepository.deleteById(id);
    }
}
