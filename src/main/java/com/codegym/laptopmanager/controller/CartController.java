package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.service.ICartItemsService;
import com.codegym.laptopmanager.service.ICartService;
import com.codegym.laptopmanager.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ILaptopService laptopService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private ICartItemsService cartItemsService;

    @ModelAttribute("cart")
    public Cart shopCart(){
        Cart cart =  new Cart();
        cartService.save(cart);
        return cart;
    }

    @GetMapping("/shop")
    public ModelAndView showHomePage(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("cart/list");
        Page<Laptop> laptops = laptopService.findAll(pageable);
        modelAndView.addObject("laptops",laptops);
        return modelAndView;
    }



}
