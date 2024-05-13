package com.example.se2.comment.service;

import com.example.se2.comment.model.dto.CommentRequestDto;
import com.example.se2.comment.model.entity.Comment;
import com.example.se2.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public List<Comment> findAllCommentByPostId(long postId) {
        return commentRepository.findByPostId(postId);
    }

    @Override
    public Comment saveComment(CommentRequestDto commentRequestDto) {
        return commentRepository.save(CommentRequestDto.convertToComment(commentRequestDto));
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

//    @Override
//    public List<Comment> findAllByCommentParentId(long commentParentId) {
//        return commentRepository.findAllByCommentParentId(commentParentId);
//    }
}
