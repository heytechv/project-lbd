package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.entity.Checkpoint;
import org.springframework.http.ResponseEntity;

public interface CheckpointService {

    /**
     * Utilities */
    ResponseEntity<StandardResponse> add(Checkpoint checkpoint);

    /**
     * Rest Controller */
    ResponseEntity<StandardResponse> add(CheckpointDto checkpointDto);

}
