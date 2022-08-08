package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.mapper.DelegationMapper;
import com.lbd.projectlbd.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DelegationServiceImpl implements DelegationService {

    @Autowired DelegationRepository delegationRepository;


    @Override public ResponseEntity<Object> add(DelegationDTO delegationDTO) {
        Delegation delegation = DelegationMapper.convertDtoToEntity(delegationDTO);
        delegationRepository.save(delegation);

        return new StandardResponse(HttpStatus.OK, "Delegation added").buildResponseEntity();
    }

    @Override public ResponseEntity<Object> delete(Long id) {

        return new StandardResponse(HttpStatus.OK, "Delegation deleted").buildResponseEntity();

    }




}
