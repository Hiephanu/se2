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
    public PostEntity savePost(SavePostRequestDto savePostRequestDto) {
        PostEntity postEntity = convertPost.convertToPostEntity(savePostRequestDto);
        Object url = cloudinaryService.upload(savePostRequestDto.getMultipartFile());
        postEntity.setImage(url.toString());
        return postRepository.save(convertPost.convertToPostEntity(savePostRequestDto));
    }
}
