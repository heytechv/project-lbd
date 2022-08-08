package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.entity.Checkpoint;
import com.lbd.projectlbd.mapper.CheckpointMapper;
import com.lbd.projectlbd.repository.CheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CheckpointServiceImpl implements CheckpointService {

    @Autowired CheckpointRepository checkpointRepository;
    @Autowired DelegationService delegationService;

    @Override public ResponseEntity<StandardResponse> add(CheckpointDto checkpointDto) {
        Checkpoint checkpoint = CheckpointMapper.convertDtoToEntity(checkpointDto);
        checkpoint.setDelegation(delegationService.findById(checkpointDto.getDelegationId()));
        checkpointRepository.save(checkpoint);

        return new StandardResponse(HttpStatus.OK, "Checkpoint added").buildResponseEntity();
    }
}
