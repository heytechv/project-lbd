package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;
import com.lbd.projectlbd.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl service;

    @PostMapping("/api/addComment")
    public ResponseEntity<StandardResponse> addComment(@RequestBody CommentDto comment){
        return service.add(comment);
    }

    @DeleteMapping("/api/deleteComment")
    public ResponseEntity<StandardResponse> deleteComment(@RequestBody Long id){
        return service.delete(id);
    }
}
