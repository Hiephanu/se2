package com.example.se2.post.repository;

import com.example.se2.post.model.entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    Page<PostEntity> findAll(Pageable pageable);

    @Query("SELECT p FROM PostEntity p WHERE p.user.id = :userId")
    Page<PostEntity> findByUserId(@Param("userId") long userId, Pageable pageable);
}
