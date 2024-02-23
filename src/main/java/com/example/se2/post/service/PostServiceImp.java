package com.example.se2.post.service;

import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {
    @Autowired
    private final PostRepository postRepository;

    @Override
    public List<PostEntity> getListPostForYou(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<PostEntity> postForYou = postRepository.findAll(pageRequest);
        return postForYou.getContent();
    }

    @Override
    public PostEntity updateNumberCommentPost(long postId) {
        postRepository.findById(postId).ifPresent(postEntity -> postEntity.setHeartNumber(postEntity.getHeartNumber() + 1));
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public PostEntity unHeartUpdate(long postId) {
        postRepository.findById(postId).ifPresent(postEntity -> postEntity.setHeartNumber(postEntity.getHeartNumber() - 1));
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public PostEntity updateNumberHeartPost(long postId) {
        postRepository.findById(postId).ifPresent(postEntity -> postEntity.setCommentNumber(postEntity.getCommentNumber() + 1));
        return postRepository.findById(postId).orElse(null);
    }
}
