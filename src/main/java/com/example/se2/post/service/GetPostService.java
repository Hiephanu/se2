package com.example.se2.post.service;

import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetPostService {
    public List<PostEntity> getListPostForYou(int page,int size);
}
