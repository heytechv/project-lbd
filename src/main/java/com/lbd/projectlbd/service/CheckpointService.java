package com.lbd.projectlbd.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.entity.Checkpoint;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CheckpointService {

    /**
     * Utilities */
    void add(Checkpoint checkpoint);
    void deleteCheckpoint(Long id);
    List<CheckpointDto> getCheckpoint(Long id);
    void update(Long id,CheckpointDto checkpointDto);
    void patch(Long id, JsonPatch patch);
    /**
     * Rest Controller */
//    ResponseEntity<StandardResponse> add(CheckpointDto checkpointDto);

}
