package com.example.se2.post.service;

import com.example.se2.Cloudinary.CloudinaryService;
import com.example.se2.follow.model.entity.Follow;
import com.example.se2.follow.service.FollowService;
import com.example.se2.post.converter.ConvertPost;
import com.example.se2.post.model.dto.PostDto;
import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.repository.PostRepository;
import com.example.se2.share.exception.NotFoundException;
import com.example.se2.user.model.User;
import com.example.se2.user.service.CustomUserDetail;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetail customUserDetail = (CustomUserDetail) authentication.getPrincipal();
        User user = customUserDetail.getUserEntity();

        PostEntity postEntity = new PostEntity();
        try {
            Object url = cloudinaryService.upload(savePostRequestDto.getMultipartFile());
            postEntity.setContent(savePostRequestDto.getContent());
            postEntity.setImage(url.toString());
            postEntity.setUser(user);
        } catch (RuntimeException e) {
            postEntity.setContent(savePostRequestDto.getContent());
            postEntity.setImage("");
            postEntity.setUser(user);
        }

        return postRepository.save(postEntity);
    }
    @Override
    public List<PostEntity> getListPostByUserId(long userID, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<PostEntity> postPage = postRepository.findByUserId(userID, pageRequest);
        return postPage.getContent();
    }

    @Override
    public PostEntity getPostById(long id) {
        Optional<PostEntity> postEntity = postRepository.findById(id);
        if(postEntity.isPresent()) {
            return postEntity.get();
        } else {
            throw  new NotFoundException("Post not found");
        }
    }
}
