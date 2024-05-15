package com.example.se2.user.controller;

import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class SearchUserController {
    private UserDetailsService userDetailsService;
    private UserService userService;
    @GetMapping("/search")
    public String getSearchUserPage(Model model, Principal principal) {
        UserReturnDto userReturnDto = userService.getUserByUsername(principal.getName());
        System.out.println(userReturnDto);
        model.addAttribute("user",userReturnDto);
        return "search";
    }

}
