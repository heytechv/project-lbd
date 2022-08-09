package com.lbd.projectlbd.mapper;


import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;


public class CommentMapper {

    public static Comment convertCommentToEntity(CommentDto commentDto){
        Comment comment=new Comment();
        comment.setAuthor(commentDto.getAuthor());
        comment.setDate(commentDto.getDate());
        comment.setText(commentDto.getContent());
        return comment;

    }

    public static CommentDto convertCommentToDto(Comment comment){
        CommentDto commentDto=new CommentDto();
        commentDto.setAuthor(comment.getAuthor());
        commentDto.setDate(comment.getDate());
        commentDto.setContent(comment.getText());
        commentDto.setParentId(comment.getComment().getId());
        commentDto.setDelegationId(comment.getDelegation().getId());
        return commentDto;
    }
}
