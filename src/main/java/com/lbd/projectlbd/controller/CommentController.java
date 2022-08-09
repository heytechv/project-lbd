package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    CommentServiceImpl service;

    @PostMapping("/api/addComment")
    public ResponseEntity<StandardResponse> addComment(@RequestBody CommentDto comment) {
        service.add(comment);
        return new StandardResponse(HttpStatus.OK, "Comment added").buildResponseEntity();
    }

    @DeleteMapping("/api/deleteComment")
    public ResponseEntity<StandardResponse> deleteComment(@RequestBody Long id) {
        service.delete(id);
        return new StandardResponse(HttpStatus.OK, "Comment deleted").buildResponseEntity();
    }

    @PutMapping("/api/{id}/updateComment")
    public ResponseEntity<StandardResponse> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {
        service.update(id, commentDto);
        return new StandardResponse(HttpStatus.OK, "Comment updated").buildResponseEntity();
    }

    @GetMapping("/api/comment/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @GetMapping("/api/comment/delegation/{delegationId}")
    public ResponseEntity<List<CommentDto>> getCommentByDelegationId(@PathVariable Long delegationId) {
        return ResponseEntity.ok().body(service.getAllByDelegationId(delegationId));
    }
}

