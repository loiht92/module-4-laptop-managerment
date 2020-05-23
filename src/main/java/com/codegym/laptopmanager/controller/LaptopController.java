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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.nio.charset.StandardCharsets;
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

    @GetMapping("/create")
    public ModelAndView showFormCreateLaptop(){
        ModelAndView modelAndView = new ModelAndView("laptop/create");
        modelAndView.addObject("laptop", new Laptop());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView saveLaptop(@ModelAttribute("laptop") Laptop laptop, RedirectAttributes redirect){
        laptopService.save(laptop);
        redirect.addFlashAttribute("message", "create laptop successfully !");
        return new RedirectView("/laptop");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditLaptop(@PathVariable Long id){
        Optional<Laptop> laptop = laptopService.findById(id);
        if (laptop.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/laptop/edit");
            modelAndView.addObject("laptop", laptop.get());
            return modelAndView;
        } else {
            return new ModelAndView("/laptop/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView updateLaptop(@ModelAttribute("laptop") Laptop laptop, RedirectAttributes redirect){
        laptopService.save(laptop);
        redirect.addFlashAttribute("message","edit laptop successfully !");
        return new RedirectView("/laptop");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteCustomer(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        //customer.getName()?
        //customer.firstName?
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        } else {
            return new ModelAndView("/customer/error");
        }
    }
    //delete
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirect){
        customerService.remove(customer.getId());
        redirect.addFlashAttribute("message", "delete customer successfully !");
        return "redirect:/customer";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCustomer(@PathVariable Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/customer/view");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("/customer/error");
        }
    }






}
