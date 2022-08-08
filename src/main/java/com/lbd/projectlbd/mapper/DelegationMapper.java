package com.lbd.projectlbd.mapper;

import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;


public class DelegationMapper {


    public static Delegation convertDtoToEntity(DelegationDTO delegationDTO) {
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

    public static DelegationDTO convertEntityToDto(Delegation delegation) {
        DelegationDTO delegationDTO = new DelegationDTO();
        delegationDTO.setStartDate(delegation.getStartDate());
        delegationDTO.setEndDate(delegation.getEndDate());
        delegationDTO.setName(delegation.getName());
        delegationDTO.setLastname(delegation.getLastname());
        delegationDTO.setCity(delegation.getCity());
        delegationDTO.setCountryCode(delegation.getCountryCode());
        delegationDTO.setDescription(delegation.getDescription());

        return delegationDTO;
    }

}
