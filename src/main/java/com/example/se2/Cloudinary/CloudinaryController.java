package com.example.se2.Cloudinary;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/image/upload")
@RequiredArgsConstructor
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;


    @PostMapping
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file){
        Map data = this.cloudinaryService.upload(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
