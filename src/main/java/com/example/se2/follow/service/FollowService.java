package com.example.se2.follow.service;

import com.example.se2.follow.model.dto.FollowPostDto;
import com.example.se2.follow.model.entity.Follow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FollowService {
     boolean checkFollow(long followerId, long followedId);
     Follow saveFollow(FollowPostDto followPostDto);
     void unFollow(long id);
    List<Follow> getAllFollowByFollowerId(long followerId);
    List<Follow> getAllFollowByFollowedId(long followedId);
}
