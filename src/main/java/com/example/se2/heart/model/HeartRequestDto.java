package com.example.se2.heart.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class HeartRequestDto {
    private long userId;
    private long postId;
    public static HeartEntity convertToHeartEntity(HeartRequestDto heartRequestDto){
        HeartEntity heart = new HeartEntity();
        heart.setUserId(heartRequestDto.getUserId());
        heart.setPostId(heartRequestDto.getPostId());
        return heart;
    }
}
