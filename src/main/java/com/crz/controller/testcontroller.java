package com.crz.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testcontroller {


    @RequestMapping("/test")
    String index(String username,String password){
        System.out.println(username+' '+password);
        return "test";
    }
}