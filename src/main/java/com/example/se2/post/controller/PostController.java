package com.example.se2.post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
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
