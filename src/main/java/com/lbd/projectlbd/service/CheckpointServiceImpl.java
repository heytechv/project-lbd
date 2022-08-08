package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.entity.Checkpoint;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.mapper.CheckpointMapper;
import com.lbd.projectlbd.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckpointServiceImpl implements CheckpointService {

    @Autowired CheckpointRepository checkpointRepository;


    /**
     * Utilities */
    @Override public ResponseEntity<StandardResponse> add(Checkpoint checkpoint) {
        checkpointRepository.save(checkpoint);
        return new StandardResponse(HttpStatus.OK, "Checkpoint added").buildResponseEntity();
    }


    /**
     * Rest Controller */
    @Override public ResponseEntity<StandardResponse> add(CheckpointDto checkpointDto) {
//        Checkpoint checkpoint = CheckpointMapper.convertDtoToEntity(checkpointDto);
//        Delegation delegation = delegationService.findById(checkpointDto.getDelegationId());
//
//        checkpoint.setDelegation(delegation);
//
//
//
//        checkpointRepository.save(checkpoint);

        return new StandardResponse(HttpStatus.OK, "Checkpoint added").buildResponseEntity();
    }
}
