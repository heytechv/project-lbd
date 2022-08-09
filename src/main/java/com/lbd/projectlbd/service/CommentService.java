package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity<StandardResponse> add(CommentDto comment);
    ResponseEntity<StandardResponse> delete(Long id);
    Comment findById(Long id);
}
