package com.example.se2.post.controller;

import com.example.se2.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.lang.reflect.Array;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PostController {
    private PostService getPostService;
    @Autowired
    UserDetailsService userDetailsService;
    @RequestMapping("")
    public String forYou(Model model,  Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        System.out.println(getPostService.getListPostForYou(0,5));
        return "index";
    }
    @RequestMapping("/following")
    public String following(Model model){
        return "following";
    }
}
