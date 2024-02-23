package com.example.se2.post.service;

import com.example.se2.post.model.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<PostEntity> getListPostForYou(int page,int size);
    PostEntity updateNumberHeartPost(long postId);
    PostEntity unHeartUpdate(long postId);
    PostEntity updateNumberCommentPost(long postId);
}
