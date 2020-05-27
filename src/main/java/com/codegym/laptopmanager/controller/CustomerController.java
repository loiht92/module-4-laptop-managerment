package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.model.Orders;
import com.codegym.laptopmanager.service.ICustomerService;
import com.codegym.laptopmanager.service.ILaptopService;
import com.codegym.laptopmanager.service.IOrdersService;
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

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ILaptopService laptopService;

    @GetMapping
    public ModelAndView listCustomer(@RequestParam("name") Optional<String> name, @PageableDefault(size = 3) Pageable pageable){
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
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }else {
            return new ModelAndView("/customer/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView editCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Edit customer successfully !" );
        return new RedirectView("/customer");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }else {
            return new ModelAndView("/customer/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
        Iterable<Orders> orders = ordersService.findAllByCustomer(customer);
        Iterable<Laptop> laptops = laptopService.findAllByCustomer(customer);
        for(Orders order: orders){
            order.setCustomer(null);
        }
        for(Laptop laptop: laptops){
            laptop.setCustomer(null);
        }
        customerService.remote(customer.getId());
        redirect.addFlashAttribute("message", "Delete customer successfully !" );
        return new RedirectView("/customer");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }
        return new ModelAndView("/customer/error");
    }
}
