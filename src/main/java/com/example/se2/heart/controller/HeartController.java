package com.example.se2.heart.controller;

import com.example.se2.heart.model.HeartRequestDeleteDto;
import com.example.se2.heart.model.HeartRequestDto;
import com.example.se2.heart.service.HeartService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heart")
@AllArgsConstructor
public class HeartController {
    private HeartService heartService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getALLHeart(@PathVariable String id){
        return ResponseEntity.ok(heartService.findAllHeartByPostId(id));
    }
    @GetMapping("/check")
    public ResponseEntity<?> checkUserHeartPost(@RequestParam(name = "userId") String userId,
                                                @RequestParam(name = "postId") String postId){
        return ResponseEntity.ok(heartService.checkUserHeartPost(Long.parseLong(postId),Long.parseLong(userId)));
    }
    @PostMapping("")
    public ResponseEntity<?> heartPost(@RequestBody HeartRequestDto heartRequestDto){
        return ResponseEntity.ok(heartService.heartPost(heartRequestDto));
    }
    @DeleteMapping("")
    public ResponseEntity<?> unHeartPost(@RequestBody HeartRequestDeleteDto heartRequestDeleteDto){
        heartService.unHeartPost(heartRequestDeleteDto.getUserId(),heartRequestDeleteDto.getPostId());
        return ResponseEntity.ok(null);
    }
}
