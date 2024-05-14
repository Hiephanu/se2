package com.example.se2.post.service;

import com.example.se2.Cloudinary.CloudinaryService;
import com.example.se2.follow.model.entity.Follow;
import com.example.se2.follow.service.FollowService;
import com.example.se2.post.converter.ConvertPost;
import com.example.se2.post.model.dto.PostDto;
import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;
    private final ConvertPost convertPost;
    private final FollowService followService;
    private final CloudinaryService cloudinaryService;

    @Override
    public List<PostEntity> getListPostForYou(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<PostEntity> postForYou = postRepository.findAll(pageRequest);
        return postForYou.getContent();
    }

    @Override
    public List<PostEntity> getListPostFollow(int userId,int page, int size) {
        List<Follow> follows = followService.getAllFollowByFollowerId(userId);
        List<PostEntity> posts = new ArrayList<>();
        follows.forEach(follow -> {
            List<PostEntity> userPosts = getListPostByUserId(follow.getFollowedId(), page, size);
            posts.addAll(userPosts);
        });
        return posts;
    }

    @Override
    public PostEntity savePost(SavePostRequestDto savePostRequestDto) {
//        PostEntity postEntity = convertPost.convertToPostEntity(savePostRequestDto);
        PostEntity postEntity = new PostEntity();
        Object url = cloudinaryService.upload(savePostRequestDto.getMultipartFile());
        postEntity.setContent(savePostRequestDto.getContent());
        postEntity.setImage(url.toString());
//        return postRepository.save(convertPost.convertToPostEntity(savePostRequestDto));
        return postRepository.save(postEntity);
    }
    @Override
    public List<PostEntity> getListPostByUserId(long userID, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<PostEntity> postPage = postRepository.findByUserId(userID, pageRequest);
        return postPage.getContent();
    }
}
