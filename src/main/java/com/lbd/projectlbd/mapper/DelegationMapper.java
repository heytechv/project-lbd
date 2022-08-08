package com.lbd.projectlbd.mapper;

import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DelegationMapper {

    DelegationMapper INSTANCE = Mappers.getMapper(DelegationMapper.class);

    Delegation convertDtoToEntity(DelegationDTO delegationDTO);
}
