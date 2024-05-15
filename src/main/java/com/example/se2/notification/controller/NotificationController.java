package com.example.se2.notification.controller;

import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class NotificationController {
    private UserService userService;
    @RequestMapping("/notification")
    public String notificationPage(Model model, Principal principal) {
        UserReturnDto userReturnDto = userService.getUserByUsername(principal.getName());
        model.addAttribute("user",userReturnDto);
        return "notification";
    }
}
