package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.*;
import com.codegym.laptopmanager.service.ILaptopService;
import com.codegym.laptopmanager.service.IOrdersService;
import com.codegym.laptopmanager.service.IProducerService;
import com.codegym.laptopmanager.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    private ILaptopService laptopService;
    @Autowired
    private IStatusService statusService;
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private IProducerService producerService;

    @ModelAttribute("statuses")
    public Iterable<Status> statuses(){
        return statusService.findAll();
    }
    @ModelAttribute("orders")
    public Page<Orders> orders(Pageable pageable){
        return ordersService.findAll(pageable);
    }
    @ModelAttribute("producer")
    public Page<Producer> producers(Pageable pageable){
        return producerService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView listCustomer(@RequestParam("name") Optional<String> name,
                                     @RequestParam(required = false) Long statusId,
                                     @PageableDefault(size = 3) Pageable pageable) {
        Page<Laptop> laptops;
        if (name.isPresent()){
            laptops = laptopService.findAllByName(name.get(), pageable);
        } else {
            laptops = laptopService.findAll(pageable);
        }

        Optional<Status> status = Objects.nonNull(statusId)
                ? statusService.findById(statusId)
                : Optional.empty();
        if (status.isPresent()) {
            laptops = new PageImpl<>(status.get().getLaptops());
        }
        ModelAndView modelAndView = new ModelAndView("laptop/list");
        modelAndView.addObject("laptops", laptops);
        return modelAndView;
    }






}
