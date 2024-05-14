package com.example.se2.heart.service;

import com.example.se2.heart.model.HeartEntity;
import com.example.se2.heart.model.HeartRequestDto;
import com.example.se2.heart.repository.HeartRepository;
import com.example.se2.post.service.PostService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HeartServiceImp implements HeartService{
    private HeartRepository heartRepository;

    private PostService postService;

    @Override
    public HeartEntity heartPost(HeartRequestDto heartRequestDto) {
        return heartRepository.save(HeartRequestDto.convertToHeartEntity(heartRequestDto));
    }

    @Transactional
    @Override
    public void unHeartPost(long userId, long postId) {
        try{
            heartRepository.deleteByUserIdAndPostId(userId,postId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<HeartEntity> findAllHeartByPostId(String id) {
        return heartRepository.findAllByPostId(Long.parseLong(id));
    }

    @Override
    public Boolean checkUserHeartPost(long postId, long userId) {
        Optional<HeartEntity> heart = heartRepository.findByPostIdAndUserId(postId,userId);
        return heart.isPresent();
    }
}
