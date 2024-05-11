package com.example.se2.post.controller;

import com.example.se2.Cloudinary.CloudinaryService;
import com.example.se2.post.model.dto.PostDto;
import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.service.PostService;
import com.sun.tools.jconsole.JConsoleContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    private CloudinaryService cloudinaryService;
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PostService postService;
    
    @PostMapping("/post/create")
    public String createPost(@ModelAttribute SavePostRequestDto savePostRequestDto, BindingResult result) {
        if(!result.hasErrors()) {
            postService.savePost(savePostRequestDto);
            return "redirect:/";
        } else {
            return "";
        }

    }
    @RequestMapping("")
    public String forYou(Model model,  Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        List<PostEntity> posts = getPostService.getListPostForYou(0,5);
        SavePostRequestDto savePostRequestDto = new SavePostRequestDto();
        model.addAttribute("user", userDetails);
        model.addAttribute("posts", posts);
        model.addAttribute("savePostRequestDto", savePostRequestDto);
        return "index";
    }
    @RequestMapping("/follow")
    public String following(Model model){
        List<PostEntity> posts=  getPostService.getListPostFollow(1, 0,5);
        model.addAttribute("posts", posts);
        return "follow";
    }
}
