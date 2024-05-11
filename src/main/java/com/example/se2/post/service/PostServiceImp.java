package com.example.se2.post.service;

import com.example.se2.Cloudinary.CloudinaryService;
import com.example.se2.post.converter.ConvertPost;
import com.example.se2.post.model.dto.SavePostRequestDto;
import com.example.se2.post.model.entity.PostEntity;
import com.example.se2.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImp implements PostService {
    private final PostRepository postRepository;
    private final ConvertPost convertPost;

    private final CloudinaryService cloudinaryService;

    @Override
    public List<PostEntity> getListPostForYou(int page,int size) {
        PageRequest pageRequest = PageRequest.of(page,size);
        Page<PostEntity> postForYou = postRepository.findAll(pageRequest);
        return postForYou.getContent();
    }

    @Override
    public List<PostEntity> getListPostFollow(int userId,int page, int size) {
        List<Integer> userFollow = new ArrayList<>();
        userFollow.add(1);
        userFollow.add(2);
        List<PostEntity> postEntities =  getListPostByUserId(userFollow.get(0),page,size);
        System.out.println(userFollow.get(0));
        for (PostEntity postEntity : postEntities) {
            System.out.println("Post + " + postEntity.getContent());
        }
        return postEntities;
    }

    @Override
    public PostEntity savePost(SavePostRequestDto savePostRequestDto) {
        PostEntity postEntity = convertPost.convertToPostEntity(savePostRequestDto);
        Object url = cloudinaryService.upload(savePostRequestDto.getMultipartFile());
        postEntity.setImage(url.toString());
        return postRepository.save(convertPost.convertToPostEntity(savePostRequestDto));
    }
    @Override
    public List<PostEntity> getListPostByUserId(long userID, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<PostEntity> postPage = postRepository.findByUserId(userID, pageRequest);
        return postPage.getContent();
    }
}
