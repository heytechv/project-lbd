package com.lbd.projectlbd.service;

import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.repository.DelegationRepository;
import org.springframework.stereotype.Service;

@Service
public class DelegationServiceImpl implements DelegationService {

    DelegationRepository delegationRepository;
    public DelegationServiceImpl(DelegationRepository delegationRepository){
        this.delegationRepository=delegationRepository;

    }
    @Override public Delegation add(Delegation delegation){
        return delegationRepository.save(delegation);

    }

    @Override
    public void delete() {

    }
}
