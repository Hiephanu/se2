package com.example.se2.comment.controller;

import com.example.se2.comment.model.dto.CommentRequestDto;
import com.example.se2.comment.model.entity.Comment;
import com.example.se2.comment.service.CommentService;
import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.user.service.CustomUserDetail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class CommentController {
    @Autowired
    private CommentService commentService;
//    @GetMapping("/post/{id}")
//    public ResponseEntity<?> getAllPostComment(@PathVariable String id){
//        return ResponseEntity.ok(commentService.findAllCommentByPostId(Long.parseLong(id)));
//    }
//    @PostMapping("")
//    public ResponseEntity<?> commentPost(@RequestBody CommentRequestDto commentRequestDto){
//        return ResponseEntity.ok(commentService.saveComment(commentRequestDto));
//    }
//    @PostMapping("/comment/{id}")
//    public ResponseEntity<?> commentComment(@PathVariable String id){
//        return ResponseEntity.ok(commentService.findAllByCommentParentId(Long.parseLong(id)));
//    }

    @PostMapping("/comment/create")
    public ResponseEntity<?> createComment(@ModelAttribute CommentRequestDto commentRequestDto, BindingResult result) {
        if(!result.hasErrors()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
            Long userId = customUserDetail.getUserId();
            System.out.println(commentRequestDto.getPostId());
            Comment comment = new Comment();
            comment.setUserId(userId);
            comment.setContent(commentRequestDto.getContent());
            comment.setPostId(commentRequestDto.getPostId());

            return ResponseEntity.ok(commentService.saveComment(comment));
        } else {
            return ResponseEntity.status(400).body("Bad Request");
        }
    }

}
