package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    CommentDto add(CommentDto comment);
    Comment delete(Long id);
    Comment findById(Long id);
}
