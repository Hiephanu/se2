package com.example.se2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/")
    public String test(Model model){
        model.addAttribute("message","Hello how are you?");
        return "Home";
    }
    @RequestMapping("/about")
    public String About(){
        return "About";
    }
}
