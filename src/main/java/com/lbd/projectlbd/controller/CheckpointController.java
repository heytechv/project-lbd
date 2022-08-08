package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.service.CheckpointService;
import com.lbd.projectlbd.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CheckpointController {

    @Autowired CheckpointService checkpointService;

    @PostMapping("/api/addcheckpoint")
    public ResponseEntity<StandardResponse> addDelegation(@Valid @RequestBody CheckpointDto checkpointDto){
        return checkpointService.add(checkpointDto);
    }

//    @DeleteMapping("/api/deletecheckpoint")
//    public ResponseEntity<StandardResponse> deleteDelegation(@RequestParam Long id){
//        return delegationService.delete(id);
//    }
}
