package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.mapper.DelegationMapper;
import com.lbd.projectlbd.service.DelegationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/delegation")
public class DelegationController {

    @Autowired DelegationService delegationService;

    @PostMapping
    public ResponseEntity<StandardResponse> addDelegation(@Valid @RequestBody DelegationDTO delegationDTO){
        delegationService.add(delegationDTO);
        return new StandardResponse(HttpStatus.OK, "Delegation added").buildResponseEntity();
    }

    @DeleteMapping("/{delegationId}")
    public ResponseEntity<StandardResponse> deleteDelegation(@PathVariable Long delegationId){
        delegationService.delete(delegationId);
        return new StandardResponse(HttpStatus.OK, "Delegation deleted").buildResponseEntity();
    }

    @GetMapping("/{delegationId}")
    public ResponseEntity<DelegationDTO> getDelegationById(@PathVariable("delegationId") Long delegationId){
        DelegationDTO foundDelegation = DelegationMapper.convertEntityToDto(
                delegationService.findById(delegationId)
        );

        return ResponseEntity.ok().body(foundDelegation);
    }

    @PutMapping("/{delegationId}")
    public ResponseEntity<StandardResponse> editDelegationById(@PathVariable Long delegationId, @RequestBody DelegationDTO delegationDTO) {
        delegationService.edit(delegationId, delegationDTO);
        return new StandardResponse(HttpStatus.OK, "Delegation edited").buildResponseEntity();
    }

}
