package com.example.se2.comment.repository;

import com.example.se2.comment.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
//    List<Comment> findAllByPostIdAndCommentParentId();
//    List<Comment> findAllByCommentParentId(long parentId);
}
