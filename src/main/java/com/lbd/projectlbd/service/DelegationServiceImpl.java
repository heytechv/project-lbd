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

//    @Autowired DelegationMapper delegationMapper;


    @Override public void add(DelegationDTO delegationDTO) {

        Delegation delegation = convertDtoToEntity(delegationDTO);
        delegationRepository.save(delegation);
    }

    @Override
    public void delete() {

    }


    private Delegation convertDtoToEntity(DelegationDTO delegationDTO) {
        Delegation delegation = new Delegation();
        delegation.setStartDate(delegationDTO.getStartDate());
        delegation.setEndDate(delegationDTO.getEndDate());
        delegation.setName(delegationDTO.getName());
        delegation.setLastname(delegationDTO.getLastname());
        delegation.setCity(delegationDTO.getCity());
        delegation.setCountryCode(delegationDTO.getCountryCode());
        delegation.setDescription(delegationDTO.getDescription());

        return delegation;
    }

}
