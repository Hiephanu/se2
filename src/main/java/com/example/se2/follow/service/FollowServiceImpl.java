package com.example.se2.follow.service;

import com.example.se2.follow.model.dto.FollowPostDto;
import com.example.se2.follow.model.entity.Follow;
import com.example.se2.follow.repository.FollowRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FollowServiceImpl  implements FollowService{
    private final FollowRepository followRepository;

    @Override
    public boolean checkFollow(long followerId, long followedId) {
        Optional<Follow> follow = followRepository.findByFollowerIdAndFollowedId(followerId, followedId);
        return follow.isPresent();
    }

    @Override
    public Follow saveFollow(FollowPostDto followPostDto) {
        Follow follow = new Follow();
        follow.setFollowedId(followPostDto.getFollowedId());
        follow.setFollowerId(followPostDto.getFollowerId());
        return followRepository.save(follow);
    }

    @Override
    public void unFollow(long id) {
        followRepository.deleteById(id);
    }

    @Override
    public List<Follow> getAllFollowByFollowerId(long followerId) {
        return followRepository.findAllByFollowerId(followerId);
    }

    @Override
    public List<Follow> getAllFollowByFollowedId(long followedId) {
        return followRepository.findAllByFollowedId(followedId);
    }
}
