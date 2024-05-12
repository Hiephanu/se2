package com.example.se2.comment.service;

import com.example.se2.comment.model.dto.CommentRequestDto;
import com.example.se2.comment.model.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
//    List<Comment> findAllCommentByPostId(long postId);
    Comment saveComment(CommentRequestDto commentRequestDto);
    Comment saveComment(Comment comment);
//    List<Comment> findAllByCommentParentId(long commentId);
}
