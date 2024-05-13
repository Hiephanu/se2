package com.example.se2.follow.repository;

import com.example.se2.follow.model.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByFollowerIdAndFollowedId(long followerId, long followedId);
    List<Follow> findAllByFollowerId(long followerId);
    List<Follow> findAllByFollowedId(long followedId);
}
