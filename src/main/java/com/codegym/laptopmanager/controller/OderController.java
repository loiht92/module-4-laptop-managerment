package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.Orders;
import com.codegym.laptopmanager.service.ICustomerService;
import com.codegym.laptopmanager.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OderController {
    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ICustomerService customerService;

    @ModelAttribute("customers")
    public Page<Customer> customers(Pageable pageable){
       return customerService.findAll(pageable);
    }
    @GetMapping
    public ModelAndView listOrders(@RequestParam("orders") Optional<String> orders_date, Pageable pageable){
        Page<Orders> orders;
        if (orders_date.isPresent()){
            orders = ordersService.findAllByDateOrders(orders_date.get(), pageable);
        }else {
            orders = ordersService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/orders/list");
        modelAndView.addObject("orders", orders);
        return modelAndView;

    }

}
