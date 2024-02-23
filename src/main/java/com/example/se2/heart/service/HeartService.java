package com.example.se2.heart.service;

import com.example.se2.heart.model.HeartEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface HeartService {
    public HeartEntity heartPost(long userId,long postId);
    void unHeartPost(Long heartId);
}
