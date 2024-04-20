package com.example.se2.heart.service;

import com.example.se2.heart.model.HeartEntity;
import com.example.se2.heart.model.HeartRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface HeartService {
    public HeartEntity heartPost(HeartRequestDto heartRequestDto);
    @Transactional
    void unHeartPost(long userId, long postId);
    List<HeartEntity> findAllHeartByPostId(String id);
    Boolean checkUserHeartPost(long userId,long postId);
}
