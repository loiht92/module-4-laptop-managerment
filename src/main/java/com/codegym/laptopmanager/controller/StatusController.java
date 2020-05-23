package com.codegym.laptopmanager.controller;

import com.codegym.laptopmanager.model.Status;
import com.codegym.laptopmanager.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping
    public ModelAndView listStatus(){
        Iterable<Status> statuses = statusService.findAll();
        ModelAndView modelAndView = new ModelAndView("/status/list");
        modelAndView.addObject("statuses", statuses);
        return modelAndView;
    }
}
