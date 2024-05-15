package com.example.se2.user.controller;

import com.example.se2.Cloudinary.CloudinaryService;
import com.example.se2.user.dto.UserDto;
import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.dto.UserUpdateDto;
import com.example.se2.user.model.User;
import com.example.se2.user.service.UserService;
import com.sun.tools.jconsole.JConsoleContext;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping(value = "")
public class LoginController {

    private UserDetailsService userDetailsService;
    private UserService userService;

    private CloudinaryService cloudinaryService;
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
        User user = userService.findUserByUsername(userDto.getUsername());
        if (user != null) {
            model.addAttribute("messageUserExist", "Email is taken");
            return "registerForm";
        }
        if (result.hasErrors()) {
            model.addAttribute("messageError", "Invalid value: Full name must be 3 to 20 characters. Age must be between 16 and 100. Password must be 8 to 15 characters.");
            return "registerForm";
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
        User user = userService.findUserById(id);
        UserUpdateDto userUpdateDto = new UserUpdateDto();
        userUpdateDto.setFullName(user.getFullName());
        userUpdateDto.setUsername(user.getUsername());
        userUpdateDto.setAddress(user.getAddress());
        userUpdateDto.setAge(user.getAge());
        userUpdateDto.setPassword(user.getPassword());
        model.addAttribute("user", user);
        model.addAttribute("userUpdateDto", userUpdateDto);
        return "userProfileEdit";
    }

    @GetMapping("/userProfile/view/{id}")
    public String getUserProfileDetail(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "userProfileDetail";
    }

//    @PostMapping("/userProfile/edit/updated/{id}")
//    public String updateUserProfile(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
//        if (result.hasErrors()) {
//            model.addAttribute("messageError", "Invalid value: Full name must be 3 to 20 characters. Age must be between 16 and 100.");
//            return "userProfileEdit";
//        }
//
//        userService.update(user);
//        model.addAttribute("message","Updated user information successfully");
//
//        return "userProfileEdit";
//    }

    @PostMapping("/userProfile/edit/updated/{id}")
    public String updateUserProfile(@Valid @ModelAttribute UserUpdateDto userUpdateDto, @PathVariable Long id, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("messageError", "Invalid value: Full name must be 3 to 20 characters. Age must be between 16 and 100.");
            return "userProfileEdit";
        }

        try {
            userService.updateDto(userUpdateDto, id);
        } catch (RuntimeException e) {
            userUpdateDto.setAvatar(null);
            userService.updateDto(userUpdateDto, id);
        }
        model.addAttribute("message","Updated user information successfully");

        return "redirect:/userProfile/" + id;
    }
}

