package com.example.se2.Cloudinary;

import lombok.AllArgsConstructor;
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
@RequestMapping("/image")
@AllArgsConstructor
public class CloudinaryController {
    private final CloudinaryService cloudinaryService;


    @PostMapping("/upload")
    public ResponseEntity<Map> uploadImage(@RequestParam("image") MultipartFile file){
        Map data = (Map) this.cloudinaryService.upload(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
