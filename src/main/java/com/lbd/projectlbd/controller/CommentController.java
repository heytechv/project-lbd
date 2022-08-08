package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.entity.Comment;
import com.lbd.projectlbd.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl service;

    @PostMapping("/api/addComment")
    public void addComment(@RequestBody Comment comment){
        service.add(comment);
    }

    @DeleteMapping("/api/deleteComment")
    public void deleteComment(@RequestBody Long id){
        service.delete(id);
    }
}
