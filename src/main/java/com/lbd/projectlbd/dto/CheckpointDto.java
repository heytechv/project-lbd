package com.lbd.projectlbd.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)  // universal DTO mapper (hide null fields)
@Setter @Getter
public class CheckpointDto {
     private Long delegationId;
     private Long masterDataCheckpointId;
     private String comment;
     private String description;
     private Boolean isChecked = false;
}
