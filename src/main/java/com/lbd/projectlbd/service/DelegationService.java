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
    void add(DelegationDTO delegationDTO);
    void delete(Long id);
    void edit(Long delegationId, DelegationDTO delegationDTO);

}
