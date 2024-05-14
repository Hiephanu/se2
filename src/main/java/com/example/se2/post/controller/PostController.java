package com.example.se2.post.controller;

import com.example.se2.post.service.PostService;
import com.example.se2.user.model.User;
import com.example.se2.user.service.CustomUserDetail;
import com.example.se2.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

    @Autowired
    UserService userService;

    @RequestMapping("")
    public String forYou(Model model, @AuthenticationPrincipal CustomUserDetail customUserDetail){
        User user = userService.findUserByUsername(customUserDetail.getUsername());
        model.addAttribute("user", user);
        return "index";
    }
    @RequestMapping("/following")
    public String following(Model model){
        return "following";
    }
}
