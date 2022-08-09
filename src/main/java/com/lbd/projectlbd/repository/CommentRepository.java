package com.lbd.projectlbd.repository;

import com.lbd.projectlbd.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("SELECT c FROM Comment c JOIN c.delegation d WHERE d.id = :delegationId")
    List<Comment> getAllByDelegationId(Long delegationId);
}
