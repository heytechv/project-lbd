package com.lbd.projectlbd.service;

import com.lbd.projectlbd.entity.Comment;

public interface CommentService {

    void add(Comment comment);
    void delete(Long id);
}
