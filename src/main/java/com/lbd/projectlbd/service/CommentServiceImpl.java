package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.mapper.CommentMapper;
import com.lbd.projectlbd.repository.CommentRepository;
import com.lbd.projectlbd.repository.DelegationRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;
    private DelegationRepository delegationRepository;


    public CommentServiceImpl(CommentRepository commentRepository, DelegationRepository delegationRepository){
        this.commentRepository=commentRepository;
        this.delegationRepository=delegationRepository;
    }

    @Override
    public Comment findById(Long id) {
        Optional<Comment> optionalDelegation = commentRepository.findById(id);
        if (optionalDelegation.isEmpty())
            throw new EntityNotFoundException("Comment with id="+id+" not found!");
        return optionalDelegation.get();
    }

    @Override @Transactional
    public CommentDto add(CommentDto commentDto) {
        Comment comment=CommentMapper.convertCommentToEntity(commentDto);
        System.out.println(commentDto);
        Optional<Delegation> optionalComment = delegationRepository.findById(commentDto.getDelegationId());
        comment.setDelegation(optionalComment.get());
        commentRepository.save(comment);
        return commentDto;
    }

    @Override @Transactional
    public Comment delete(Long id) {
        Comment comment = findById(id);
        if(!comment.getCommentSet().isEmpty())
            comment.getCommentSet().forEach(comments -> commentRepository.delete(comment));
        commentRepository.deleteById(id);
        return comment;
    }

    @Override @Transactional
    public void update(CommentDto commentDto){
         commentRepository.save(CommentMapper.convertCommentToEntity(commentDto));
    }
}
