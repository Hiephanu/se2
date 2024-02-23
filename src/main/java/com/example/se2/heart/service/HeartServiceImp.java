package com.example.se2.heart.service;

import com.example.se2.heart.model.HeartEntity;
import com.example.se2.heart.repository.HeartRepository;
import com.example.se2.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class HeartServiceImp implements HeartService{
    private HeartRepository heartRepository;

    private PostService postService;

    @Override
    public HeartEntity heartPost(long userId, long postId) {
        HeartEntity heartEntity = new HeartEntity();
        heartEntity.setUserId(userId);
        heartEntity.setPostId(postId);
        LocalDate date = java.time.LocalDate.now();
        heartEntity.setCreatedAt(date);

        postService.updateNumberHeartPost(postId);

        return heartRepository.save(heartEntity);
    }

    @Override
    public void unHeartPost(Long heartId) {
        try{
            heartRepository.deleteById(heartId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
