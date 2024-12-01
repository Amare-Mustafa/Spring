package com.example.SimpleWebApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// this will return the data and not the entire view
/**
 * Rest controller handles RESTfull services
 * Rest: just send the data and let the front end handle how to display it
 */
public class Controller_Home {
    @RequestMapping("/")//if it reqests for "/" then run this method
    //we can also use @ResponseBody to get the data only
    public String greet(){
        System.out.println("hello");
        return "Welcome to SpringBoot Web";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is about page, I am learning SpringBoot web and it's coooolllll!!!";
    }
}
