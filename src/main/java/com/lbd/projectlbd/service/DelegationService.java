package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;

public interface DelegationService {

    void add(DelegationDTO delegationDTO);
    void delete();

}
