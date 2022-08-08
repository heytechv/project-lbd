package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;
import org.springframework.http.ResponseEntity;

public interface DelegationService {

    /**
     * Utilities */
    Delegation findById(Long id);

    /**
     * Rest Controller */
    ResponseEntity<StandardResponse> add(DelegationDTO delegationDTO);
    ResponseEntity<StandardResponse> delete(Long id);

}
