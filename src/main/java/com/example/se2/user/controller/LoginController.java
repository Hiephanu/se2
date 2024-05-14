package com.example.se2.user.controller;

import com.example.se2.user.dto.UserDto;
import com.example.se2.user.model.User;
import com.example.se2.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping(value = "")
public class LoginController {

    private UserDetailsService userDetailsService;
    private UserService userService;

    public LoginController(UserDetailsService userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String getRegisterForm(@ModelAttribute("user") UserDto userDto) {
        return "registerForm";
    }

    @PostMapping("/register")
    public String saveUser(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("messageError", "Invalid input, username must be 6 to 20 character, password must be 8 to 15 character");
            return "registerForm";
        } else {
            User user = userService.findUserByUsername(userDto.getUsername());
            if (user != null) {
                model.addAttribute("messageUserExist", "Username is taken");
            }
            System.out.println("err" + result);
        }
        userService.save(userDto);
        model.addAttribute("message","Registered Successfully !");
        return "registerForm";
    }

    @GetMapping("/userProfile/{id}")
    public String getUserProfile(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "userProfile";
    }

    @GetMapping("/userProfile/edit/{id}")
    public String getUserProfileEdit(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "userProfileEdit";
    }

    @GetMapping("/userProfile/view/{id}")
    public String getUserProfileDetail(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "userProfileDetail";
    }

    @PostMapping("/userProfile/edit/updated/{id}")
    public String updateUserProfile(@Valid @ModelAttribute("user") User user, Model model){
        userService.update(user);
        model.addAttribute("message","Updated user information successfully");
        return "userProfileEdit";
    }
}

