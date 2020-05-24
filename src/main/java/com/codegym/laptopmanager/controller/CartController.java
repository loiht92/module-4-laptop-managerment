package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Cart;
import com.codegym.laptopmanager.model.CartItems;
import com.codegym.laptopmanager.model.Laptop;
import com.codegym.laptopmanager.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@SessionAttributes("cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @ModelAttribute("cart")
    public Cart shopCart(){
        Cart cart =  new Cart();
        cartService.saveCart(cart);
        return cart;
    }

    @GetMapping("/shop")
    public ModelAndView showHomePage(Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("cart/add-cart");
        Page<Laptop> laptops = cartService.findAllLaptop(pageable);
        modelAndView.addObject("laptops",laptops);
        return modelAndView;
    }

    @GetMapping("/add-cart/{laptop_id}")
    public RedirectView addToCart(@PathVariable Long laptop_id, @ModelAttribute("cart") Cart cart){
        Laptop laptop = cartService.findLaptopById(laptop_id);
        CartItems cartItems = cartService.findCartItemByCartAndLaptop(cart, laptop);
        if (cartItems != null){
            cartItems.setQuantity(1 + cartItems.getQuantity());
            cartItems.setTotal_price(cartItems.getTotal_price() + laptop.getPrice());
        }else {
            cartItems = new CartItems();
            cartItems.setLaptop(laptop);
            cartItems.setQuantity((long) 1);
            cartItems.setTotal_price(laptop.getPrice() * cartItems.getQuantity());
            cartItems.setCart(cart);
        }
        cartService.saveCartItems(cartItems);
        return new RedirectView("/shop");
    }

    @GetMapping("/carts")
    public ModelAndView showListCart(@ModelAttribute("cart") Cart cart){
        List<CartItems> cartItems = cartService.findCartItemByCart(cart);
        double total = 0;
        for (CartItems cartItem : cartItems){
            total = (total + cartItem.getTotal_price());
        }
        cart.setTotal_price(total);
        cartService.saveCart(cart);
        ModelAndView modelAndView = new ModelAndView("cart/list");
        modelAndView.addObject("cartItems",cartItems);
        return modelAndView;
    }

    @PostMapping("/edit")
    public RedirectView editCart(@RequestParam("quantity") Long quantity,@RequestParam("id") Long cartItemId){
        CartItems cartItem = cartService.findCartItemsById(cartItemId);
        cartItem.setQuantity(quantity);
        cartItem.setTotal_price(quantity * cartItem.getLaptop().getPrice());
        cartService.saveCartItems(cartItem);
        return new RedirectView("/carts");
    }

    @PostMapping("/remove/{cartItem_id}")
    public RedirectView removeCartItem(@PathVariable Long cartItem_id){
        cartService.removeCartItemsById(cartItem_id);
        return new RedirectView("/carts");
    }

}
