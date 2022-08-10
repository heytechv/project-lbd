package com.lbd.projectlbd.mapper;

import com.lbd.projectlbd.dto.DelegationDto;
import com.lbd.projectlbd.entity.Delegation;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;


@Mapper(componentModel = "spring")
public interface DelegationMapper {


    @Named("mapDelegationToDelegationDTO")
    DelegationDto mapDelegationToDelegationDTO(Delegation source);
    @IterableMapping(qualifiedByName = "mapDelegationToDelegationDTO")
    @Named("mapDelegationSetToDelegationDtoSet")
    Set<DelegationDto> mapDelegationSetToDelegationDtoSet(Set<Delegation> source);

    @Named("mapDelegationDtoToDelegation")
    Delegation mapDelegationDtoToDelegation(DelegationDto source);
    @IterableMapping(qualifiedByName = "mapDelegationDtoToDelegation")
    @Named("mapDelegationDtoSetToDelegationSet")
    Set<Delegation> mapDelegationDtoSetToDelegationSet(Set<DelegationDto> source);



    default Delegation convertDtoToEntity(DelegationDto delegationDTO) {
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

    default DelegationDto convertEntityToDto(Delegation delegation) {
        DelegationDto delegationDTO = new DelegationDto();
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
