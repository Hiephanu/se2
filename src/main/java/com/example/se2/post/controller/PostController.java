package com.example.se2.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostController {
    @RequestMapping("/")
    public String test(Model model){
        model.addAttribute("message","Hello how are you?");
        return "index";
    }
    @RequestMapping("/about")
    public String About(){
        return "bout";
    }
}
