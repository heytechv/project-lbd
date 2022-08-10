package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDto;
import com.lbd.projectlbd.entity.Delegation;
import org.springframework.http.ResponseEntity;

public interface DelegationService {

    /**
     * Utilities */
    Delegation findById(Long id);

    /**
     * Rest Controller */
    void add(DelegationDto delegationDTO);
    void delete(Long id);
    void edit(Long delegationId, DelegationDto delegationDTO);

}
