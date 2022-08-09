package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.CommentDto;
import com.lbd.projectlbd.entity.Comment;
import com.lbd.projectlbd.mapper.CommentMapper;
import com.lbd.projectlbd.repository.CommentRepository;
import com.lbd.projectlbd.repository.DelegationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final DelegationRepository delegationRepository;
    private final CommentMapper commentMapper;

    @Override
    public CommentDto findById(Long id) {
        return commentMapper
                .convertCommentToDto(commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment with id="+id+" not found!")));
    }

    @Override
    public List<CommentDto> getAllByDelegationId(Long delegationId) {
        if(!delegationRepository.existsById(delegationId))
            throw new EntityNotFoundException("Delegation with id="+delegationId+" not found!");
        return commentRepository.getAllByDelegationId(delegationId)
                .stream()
                .map(commentMapper::convertCommentToDto)
                .collect(Collectors.toList());
    }

    @Override @Transactional
    public void add(CommentDto commentDto) {
        if(!delegationRepository.existsById(commentDto.getDelegationId()))
            throw new EntityNotFoundException("Delegation with id="+commentDto.getDelegationId()+" not found!");
        if(commentDto.getParentId() != null && !commentRepository.existsById(commentDto.getParentId()))
            throw new EntityNotFoundException("Comment with id="+commentDto.getParentId()+" not found!");
        Comment comment = commentMapper.convertCommentToEntity(commentDto);
        commentRepository.save(comment);
    }

    @Override @Transactional
    public void update(Long id, CommentDto commentDto){
        if(commentDto.getDelegationId() != null && !delegationRepository.existsById(commentDto.getDelegationId()))
            throw new EntityNotFoundException("Delegation with id="+commentDto.getDelegationId()+" not found!");
        if(commentDto.getParentId() != null && !commentRepository.existsById(commentDto.getParentId()))
            throw new EntityNotFoundException("Comment with id="+commentDto.getParentId()+" not found!");
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment with id="+id+" not found!"));
        commentRepository.save(commentMapper.updateComment(commentDto, comment));
    }

    @Override @Transactional
    public Comment delete(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment with id="+id+" not found!"));
        if(!comment.getCommentSet().isEmpty())
            comment.getCommentSet().forEach(comments -> commentRepository.delete(comment));
        commentRepository.deleteById(id);
        return comment;
    }
}
