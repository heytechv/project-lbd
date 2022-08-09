package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;

import java.util.List;

public interface CommentService {

    void add(CommentDto comment);
    void delete(Long id);
    CommentDto findById(Long id);
    List<CommentDto> getAllByDelegationId(Long delegationId);
    void update(Long id, CommentDto commentDto);
}
