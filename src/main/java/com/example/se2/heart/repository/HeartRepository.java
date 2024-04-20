package com.example.se2.heart.repository;

import com.example.se2.heart.model.HeartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeartRepository extends JpaRepository<HeartEntity,Long> {
    void  deleteByUserIdAndPostId(long userId, long postId);
    List<HeartEntity> findAllByPostId(long postId);

    Optional<HeartEntity> findByPostIdAndUserId(long postId, long userId);
}