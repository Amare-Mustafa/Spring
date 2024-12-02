package com.example.SimpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller_Login {

    @RequestMapping("/login")
    public String login(){
        return "Login Page..";

    }
}
