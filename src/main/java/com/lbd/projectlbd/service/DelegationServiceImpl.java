package com.lbd.projectlbd.service;

import com.lbd.projectlbd.apiresponse.StandardResponse;
import com.lbd.projectlbd.dto.DelegationDTO;
import com.lbd.projectlbd.entity.Checkpoint;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.entity.MasterdataCheckpoint;
import com.lbd.projectlbd.exception.DelegationValidationException;
import com.lbd.projectlbd.mapper.DelegationMapper;
import com.lbd.projectlbd.repository.DelegationRepository;
import com.lbd.projectlbd.repository.MasterdataCheckpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

@Service
public class DelegationServiceImpl implements DelegationService {

    @Autowired DelegationRepository delegationRepository;
    @Autowired MasterdataCheckpointRepository masterdataCheckpointRepository;
    @Autowired CheckpointService checkpointService;


    /**
     * Utilities */
    @Override public Delegation findById(Long id) {
        Optional<Delegation> optionalDelegation = delegationRepository.findById(id);
        if (optionalDelegation.isEmpty())
            throw new EntityNotFoundException("Delegation with id="+id+" not found!");

        return optionalDelegation.get();
    }

    private void addCheckpointsFromMasterData(Delegation delegation) {
        // Wykorzystywanie warunkow SPEL do dodawania checkpointow do delegacji
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = new StandardEvaluationContext(delegation);

        masterdataCheckpointRepository.findAll().forEach(masterdataCheckpoint -> {
            if (parser.parseExpression(masterdataCheckpoint.getSpelExpression()).getValue(context, Boolean.class)) {
                Checkpoint c = new Checkpoint();
                c.setMasterDataCheckpointId(masterdataCheckpoint.getId());
                c.setDelegation(delegation);
                c.setDescription(masterdataCheckpoint.getDescription());
                c.setComment("added automatically");
                c.setIsChecked(false);
                checkpointService.add(c);
            }
        });
    }

    /**
     * Rest Controller */
    @Override @Transactional
    public void add(DelegationDTO delegationDTO) {
        Delegation delegation = DelegationMapper.convertDtoToEntity(delegationDTO);

        if(delegation.getStartDate().before(new Date())){
            throw new DelegationValidationException("The delegation cannot include the start date as a past date.");
        }
        if(delegation.getEndDate().before(delegation.getStartDate())){
            throw new DelegationValidationException("The start date must be before the end date.");
        }

        delegationRepository.save(delegation);

        addCheckpointsFromMasterData(delegation);
    }

    @Override @Transactional
    public void delete(Long id) {
        Delegation delegation = findById(id);

        delegation.getCheckpointSet().forEach(checkpoint -> checkpointService.delete(checkpoint));
        // todo dla komentarza tak samo usuwanie



        delegationRepository.delete(findById(id));
    }

    @Override public void edit(Long delegationId, DelegationDTO delegationDTO) {
        Delegation delegation = findById(delegationId);
        delegation.setStartDate(delegationDTO.getStartDate());
        delegation.setEndDate(delegationDTO.getEndDate());
        delegation.setName(delegationDTO.getName());
        delegation.setLastname(delegationDTO.getLastname());
        delegation.setCity(delegationDTO.getCity());
        delegation.setCountryCode(delegationDTO.getCountryCode());
        delegation.setDescription(delegationDTO.getDescription());

        delegationRepository.save(delegation);
    }





}
