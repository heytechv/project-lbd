package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import org.springframework.http.ResponseEntity;

public interface CheckpointService {

    /**
     * Rest Controller */
    ResponseEntity<StandardResponse> add(CheckpointDto checkpointDto);

}
