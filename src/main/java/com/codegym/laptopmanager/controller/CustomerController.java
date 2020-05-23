package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.Producer;
import com.codegym.laptopmanager.service.ICustomerService;
import com.codegym.laptopmanager.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ModelAndView listCustomer(@RequestParam("name") Optional<String> name, @PageableDefault(size = 10) Pageable pageable){
        Page<Customer> customers;
        if (name.isPresent()){
            customers = customerService.findAllByCustomerName(name.get(), pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateCustomer(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/creates")
    public RedirectView saveCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Create customer successfully !");
        return new RedirectView("/customer");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("producer", producer.get());
            return modelAndView;
        }else {
            return new ModelAndView("/producer/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView editProducer(@ModelAttribute("producer") Producer producer, RedirectAttributes redirect){
        producerService.save(producer);
        redirect.addFlashAttribute("message", "Edit producer successfully !" );
        return new RedirectView("/producer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteProducer(@PathVariable Long id){
        Optional<Producer> producer = producerService.findById(id);
        if (producer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/producer/delete");
            modelAndView.addObject("producer", producer.get());
            return modelAndView;
        }else {
            return new ModelAndView("/producer/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteProducer(@ModelAttribute("producer") Producer producer, RedirectAttributes redirect){
        producerService.remote(producer.getId());
        redirect.addFlashAttribute("message", "Delete producer successfully !" );
        return new RedirectView("/producer");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewProducer(@PathVariable Long id){
        Optional<Producer> producer = producerService.findById(id);
        if (producer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/producer/view");
            modelAndView.addObject("producer", producer.get());
            return modelAndView;
        }
        return new ModelAndView("/producer/error");
    }
}
