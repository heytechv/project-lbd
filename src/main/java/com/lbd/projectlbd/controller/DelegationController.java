package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.mapper.DelegationMapper;
import com.lbd.projectlbd.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DelegationController {

    @Autowired DelegationService delegationService;

    @PostMapping("/api/adddelegation")
    public ResponseEntity<StandardResponse> addDelegation(@Valid @RequestBody DelegationDTO delegationDTO){
        return delegationService.add(delegationDTO);
    }

    @DeleteMapping("/api/deletedelegation")
    public ResponseEntity<StandardResponse> deleteDelegation(@RequestParam Long id){
        return delegationService.delete(id);
    }

    @GetMapping("/api/delegation/{delegationId}")
    public ResponseEntity<DelegationDTO> getDelegationById(@PathVariable("delegationId") Long delegationId){
        DelegationDTO foundDelegation = DelegationMapper.convertEntityToDto(
                delegationService.findById(delegationId)
        );

        return ResponseEntity.ok().body(foundDelegation);
    }
}
