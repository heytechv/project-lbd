package com.lbd.projectlbd.controller;

import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.service.DelegationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DelegationController {

    @Autowired
    DelegationServiceImpl service;

    @PostMapping("/api/addDelegation")
    public void addDelegation(@Valid @RequestBody DelegationDTO delegationDTO){
        service.add(delegationDTO);

    }

    @DeleteMapping("/api/deleteDelegation")
    public void deleteDelegation(@RequestParam Long id){
        service.delete();
    }
}
