package com.example.se2.user.controller;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(value = "")
public class LoginController {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(@ModelAttribute("user") UserDto userDto) {
        return "registerForm";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message","Registered Successfully !");
        return "registerForm";
    }
    @GetMapping("/userInfo")
    public String getUserInfo(@ModelAttribute("user") UserDto userDto) {
        return "userInfo";
    }
    @PostMapping("/userInfo/update")
    public String updateUserInfo(@ModelAttribute("user") UserDto userDto, Model model) {
        userService.save(userDto);
        model.addAttribute("message","Updated user information successfully");
        return "userInfo";
    }


//    @GetMapping("")
//    public String homepage(Model model, Principal principal) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//        model.addAttribute("user", userDetails);
//        return "homepage";
//    }
}

