package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Customer;
import com.codegym.laptopmanager.model.OrderRequest;
import com.codegym.laptopmanager.model.Orders;
import com.codegym.laptopmanager.repository.CustomerRepository;
import com.codegym.laptopmanager.repository.OrdersRepository;
import com.codegym.laptopmanager.service.ICustomerService;
import com.codegym.laptopmanager.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

import static java.util.Objects.isNull;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private OrdersRepository ordersRepo;

    @ModelAttribute("customers")
    public Page<Customer> customers(Pageable pageable){
       return customerService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView listOrders(@RequestParam("orders") Optional<String> orders_date, Pageable pageable){
        Page<Orders> orders;
        if (orders_date .isPresent()){
            orders = ordersService.findAllByDatesOrders(orders_date.get(), pageable);
        }else {
            orders = ordersService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/orders/list");
        modelAndView.addObject("orders", orders);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateOrders(){
        ModelAndView modelAndView = new ModelAndView("orders/create");
        modelAndView.addObject("orders", new Orders());
        return modelAndView;
    }

    @PostMapping("/create")
    public RedirectView saveOrders(@ModelAttribute("orders") Orders orders, RedirectAttributes redirect){
        ordersService.save(orders);
        redirect.addFlashAttribute("message", "create orders successfully !");
        return new RedirectView("/orders");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditOrders(@PathVariable Long id){
        Optional<Orders> orders = ordersService.findById(id);
        if (orders.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/orders/edit");
            Orders order = orders.get();
            OrderRequest request = new OrderRequest();
//            request.setId(order.getId());
//            request.setCustomerDates(order.getCustomerDates());
//            request.setName(order.getCustomer().getName());
//            request.setEmail(order.getCustomer().getEmail());
//            request.setAddress(order.getCustomer().getAddress());
//            request.setPhone(order.getCustomer().getPhone());
            modelAndView.addObject("orders", order);
            return modelAndView;
        } else {
            return new ModelAndView("/orders/error");
        }
    }

    @PostMapping("/edit")
    public RedirectView editOrders(@ModelAttribute("orders") Orders request, RedirectAttributes redirect) throws Exception {
        if (isNull(request)) {
            throw new Exception("Order is required!");
        }
//        Customer customer = customerRepo.findCustomerByOrders(order);
//        order.setCustomer(customer);
        System.out.println(request);

//        Orders orders = ordersRepo.findOrdersByCustomer(customer);
//        System.out.println(orders.getId());
        redirect.addFlashAttribute("message", "Edit orders successfully !" );
        return new RedirectView("/orders");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDeleteOrders(@PathVariable Long id){
        Optional<Orders> orders = ordersService.findById(id);
        if (orders.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/orders/delete");
            modelAndView.addObject("orders", orders.get());
            return modelAndView;
        }else {
            return new ModelAndView("/orders/error");
        }
    }

    @PostMapping("/delete")
    public RedirectView deleteOrders(@ModelAttribute("orders") Orders orders, RedirectAttributes redirect){
        ordersService.remote(orders.getId());
        redirect.addFlashAttribute("message", "delete orders successfully !");
        return new RedirectView("/orders");
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewOrders(@PathVariable Long id) {
        Optional<Orders> orders = ordersService.findById(id);
        if (orders.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/orders/view");
            modelAndView.addObject("orders", orders.get());
            return modelAndView;
        } else {
            return new ModelAndView("/orders/error");
        }
    }
}
