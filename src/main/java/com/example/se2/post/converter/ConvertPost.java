package com.example.se2.post.converter;

import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class ConvertPost {
    public PostEntity convertToPostEntity(SavePostRequestDto savePostRequestDto){
        PostEntity postEntity = new PostEntity();
        User user = new User();
        user.setId(savePostRequestDto.getUserId());
        postEntity.setContent(savePostRequestDto.getContent());
        postEntity.setUser(user);
        return  postEntity;
    }
}
