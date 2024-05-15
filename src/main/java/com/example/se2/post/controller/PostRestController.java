package com.example.se2.post.controller;

import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@AllArgsConstructor
public class PostRestController {
    private final PostService postService;
    @GetMapping("")
    public ResponseEntity<?> getPost(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "5") int perPage){
      try {
          return ResponseEntity.ok(postService.getListPostForYou(page,perPage));
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(500).body("Internal error");
      }
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<?> getPostById(@PathVariable long id) {
        try {
           return ResponseEntity.ok(postService.getPostById(id));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body("Internal error");
        }
    }
    @GetMapping("/{id}/follow")
    public ResponseEntity<?> getPostByUserFollow(@PathVariable("id") long id,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "5") int perPage) {
        try {
            System.out.println(id);
            return  ResponseEntity.ok(postService.getListPostByUserId(id, page,perPage));
        } catch (Exception e) {
            return  ResponseEntity.status(500).body("Internal error");
        }
    }
    @PostMapping("")
    public ResponseEntity<?> savePost(@RequestBody SavePostRequestDto savePostRequestDto){
        return ResponseEntity.ok(postService.savePost(savePostRequestDto));
    }
}
