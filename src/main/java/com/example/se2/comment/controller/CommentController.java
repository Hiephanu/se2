//package com.example.se2.comment.controller;
//
//import com.example.se2.comment.model.dto.CommentRequestDto;
//import com.example.se2.comment.service.CommentService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/comment")
//@AllArgsConstructor
//public class CommentController {
//    @Autowired
//    private CommentService commentService;
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
//
//}
