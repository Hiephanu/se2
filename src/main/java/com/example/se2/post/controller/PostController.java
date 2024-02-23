package com.example.se2.post.controller;

import com.example.se2.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class PostController {
    private PostService getPostService;
    @RequestMapping("/")
    public String forYou(Model model){
        model.addAttribute("message","Hello how are you?");
        System.out.println(getPostService.getListPostForYou(0,5));
        return "index";
    }
    @RequestMapping("/following")
    public String following(Model model){
        return "following";
    }
}
