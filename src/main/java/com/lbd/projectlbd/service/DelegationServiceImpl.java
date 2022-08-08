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

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class DelegationServiceImpl implements DelegationService {

    @Autowired DelegationRepository delegationRepository;


    /**
     * Utilities */
    @Override public Delegation findById(Long id) {
        Optional<Delegation> optionalDelegation = delegationRepository.findById(id);
        if (optionalDelegation.isEmpty())
            throw new EntityNotFoundException("Delegation with id="+id+" not found!");

        return optionalDelegation.get();
    }

    /**
     * Rest Controller */
    @Override public ResponseEntity<StandardResponse> add(DelegationDTO delegationDTO) {
        Delegation delegation = DelegationMapper.convertDtoToEntity(delegationDTO);
        delegationRepository.save(delegation);

        return new StandardResponse(HttpStatus.OK, "Delegation added").buildResponseEntity();
    }

    @Override public ResponseEntity<StandardResponse> delete(Long id) {
        delegationRepository.delete(findById(id));
        return new StandardResponse(HttpStatus.OK, "Delegation deleted").buildResponseEntity();
    }





}
