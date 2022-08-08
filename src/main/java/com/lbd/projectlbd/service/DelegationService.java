package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.DelegationDTO;
import org.springframework.http.ResponseEntity;

public interface DelegationService {

    ResponseEntity<Object> add(DelegationDTO delegationDTO);
    ResponseEntity<Object> delete(Long id);

}
