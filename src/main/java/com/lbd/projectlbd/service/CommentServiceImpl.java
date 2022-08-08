package com.lbd.projectlbd.service;

import com.lbd.projectlbd.entity.Comment;
import com.lbd.projectlbd.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository=commentRepository;
    }

    @Override
    public void add(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void delete(Long id) {
        commentRepository.deleteById(id);
    }
}
