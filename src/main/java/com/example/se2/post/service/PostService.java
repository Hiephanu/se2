package com.example.se2.post.service;

import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    public List<PostEntity> getListPostForYou(int page,int size);
    public List<PostEntity> getListPostFollow(int userId,int page,int size);
    public List<PostEntity> getListPostByUserId(long userID, int page, int size);
    public PostEntity getPostById(long id);
    public PostEntity savePost(SavePostRequestDto savePostRequestDto);
}
