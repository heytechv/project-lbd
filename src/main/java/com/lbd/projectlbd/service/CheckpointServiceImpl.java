package com.lbd.projectlbd.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.lbd.projectlbd.dto.CheckpointDto;
import com.lbd.projectlbd.entity.Checkpoint;
import com.lbd.projectlbd.entity.Delegation;
import com.lbd.projectlbd.mapper.CheckpointMapper;
import com.lbd.projectlbd.mapper.mapper;
import com.lbd.projectlbd.repository.CheckpointRepository;
import com.lbd.projectlbd.repository.DelegationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckpointServiceImpl implements CheckpointService {

     CheckpointRepository checkpointRepository;
     DelegationRepository delegationRepository;

     mapper map;


    public CheckpointServiceImpl(CheckpointRepository checkpointRepository, DelegationRepository delegationRepository, mapper map) {
        this.checkpointRepository = checkpointRepository;
        this.delegationRepository = delegationRepository;
        this.map=map;
    }

    /**
     * Utilities */
    @Override public void add(Checkpoint checkpoint) {
        checkpointRepository.save(checkpoint);

    }


    @Override
    public List<CheckpointDto> getCheckpoint(Long id){
        Optional<Delegation> delegation= delegationRepository.findById(id);

       return  delegation.map(delegation1 -> delegation1.getCheckpointSet().stream().map(CheckpointMapper::convertEntityToDto).collect(Collectors.toList())
         )
                 .orElseThrow(()->new EntityNotFoundException("Delegation not found!"));

    }

    @Override
    public void deleteCheckpoint(Long id){
        Optional<Checkpoint> checkpointOptional=checkpointRepository.findById(id);
        checkpointOptional.ifPresent(optional->optional.getDelegation().getCheckpointSet().remove(checkpointOptional.get()));

        checkpointRepository.deleteById(id);
    }

    @Override
    public void update(Long id,CheckpointDto checkpointDto){
        Checkpoint checkpoint=checkpointRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment with id=" + id + " not found!"));
        checkpointRepository.save(map.updateCheckpoint(checkpoint,checkpointDto));
    }

    @Override
    public void patch(Long id, JsonPatch patch) {
        try {
            Checkpoint checkpoint = checkpointRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Comment with id=" + id + " not found!"));
            Checkpoint checkpointPatched = applyPatchToCheckpoint(patch, checkpoint);
            update(id,map.mapCheckpointToDCheckpointDTO(checkpointPatched) );
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private Checkpoint applyPatchToCheckpoint(JsonPatch patch, Checkpoint targetCheckpoint) throws JsonPatchException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode patched = patch.apply(objectMapper.convertValue(targetCheckpoint, JsonNode.class));
        return objectMapper.treeToValue(patched, Checkpoint.class);
    }




}
