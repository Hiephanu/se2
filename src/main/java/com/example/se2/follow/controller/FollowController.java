package com.example.se2.follow.controller;

import com.example.se2.follow.model.dto.FollowPostDto;
import com.example.se2.follow.model.entity.Follow;
import com.example.se2.follow.service.FollowService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follow")
@AllArgsConstructor
public class FollowController {
    private final FollowService followService;

    @PostMapping("/check-follow")
    public ResponseEntity<?> checkFollow(@RequestBody FollowPostDto followPostDto)  {
        try {
            boolean check = followService.checkFollow(followPostDto.getFollowerId(),followPostDto.getFollowedId());
            return  ResponseEntity.ok(check);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @GetMapping("/followed/{id}")
    public ResponseEntity<?> getAllFollowerByFollowedId(@PathVariable long id) {
        try {
            List<Follow> follows = followService.getAllFollowByFollowerId(id);
            return  ResponseEntity.ok(follows);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
    @PostMapping("")
    public ResponseEntity<?> saveFollow(@RequestBody FollowPostDto followPostDto) {
        try {
            Follow follow = followService.saveFollow(followPostDto);
            return  ResponseEntity.ok(follow);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> unFollow(@PathVariable("id") long id) {
        try {
            followService.unFollow(id);
            return  ResponseEntity.ok(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
