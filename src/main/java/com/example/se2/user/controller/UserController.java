package com.example.se2.user.controller;

import com.example.se2.user.dto.UserReturnDto;
import com.example.se2.user.service.SearchUserByFullNameService;
import com.example.se2.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final SearchUserByFullNameService searchUserByFullName;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") long id) {
        try {
            UserReturnDto userReturnDto = userService.getUserById(id);
            return  ResponseEntity.ok(userReturnDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Internal error");
        }
    }
    @GetMapping("/username/{name}")
    public ResponseEntity<?> getUserByUserName(@PathVariable("name") String name) {
        try {
             UserReturnDto userReturnDto = userService.getUserByUsername(name);
             return ResponseEntity.ok().body(userReturnDto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Interal error");
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchUserByKeyword(@RequestParam(name = "keyword") String keyword) {
        try {
            List<UserReturnDto> userReturnDtoList = searchUserByFullName.searchUserByFullName(keyword);
            return ResponseEntity.ok(userReturnDtoList);
        } catch (Exception e) {
            e.printStackTrace();
            return  ResponseEntity.internalServerError().body("Internal error");
        }
    }
}
