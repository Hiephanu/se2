package com.example.se2.comment.model.dto;

import com.example.se2.comment.model.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    private long userId;
    private long postId;
    private String content;

    public static Comment convertToComment(CommentRequestDto commentRequestDto){
        Comment comment = new Comment();
        comment.setCommentParentId(null);
        comment.setUserId(commentRequestDto.getUserId());
        comment.setPostId(commentRequestDto.getPostId());
        comment.setContent(commentRequestDto.getContent());
        return  comment;
    }
}
