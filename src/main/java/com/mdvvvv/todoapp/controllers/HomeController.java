package com.mdvvvv.todoapp.controllers;

import com.mdvvvv.todoapp.services.TodoItemService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.time.ZoneId;

@Controller
public class HomeController {
    private final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemService.getAll());
        String day = Instant.now().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfWeek().toString().toLowerCase();
        day = day.substring(0,1).toUpperCase() + day.substring(1);
        modelAndView.addObject("today", day);
        return modelAndView;
    }


}