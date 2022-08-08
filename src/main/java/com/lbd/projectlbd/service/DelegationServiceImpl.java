package com.lbd.projectlbd.service;

import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.mapper.DelegationMapper;
import com.lbd.projectlbd.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelegationServiceImpl implements DelegationService {

    @Autowired DelegationRepository delegationRepository;


    @Override public void add(DelegationDTO delegationDTO) {
        Delegation delegation = DelegationMapper.convertDtoToEntity(delegationDTO);
        delegationRepository.save(delegation);
    }

    @Override
    public void delete() {

    }




}
