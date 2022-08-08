package com.lbd.projectlbd.Controllers;

import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.service.DelegationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
public class DelegationController {

    @Autowired
    DelegationServiceImpl service;

    @PostMapping("/api/addDelegation")
    public void addDelegation(@RequestBody DelegationDTO delegationDTO){
        service.add(delegationDTO);

    }

    @DeleteMapping("/api/deleteDelegation")
    public void deleteDelegation(@RequestParam Long id){
        service.delete();
    }
}
