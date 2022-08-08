package com.lbd.projectlbd.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lbd.projectlbd.entity.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
public class DelegationDTO {

    private Timestamp startDate;
    private Timestamp endDate;
    private String name;
    private String lastname;
    private String city;
    private Locale countryCode;  // Arrays.asList(Locale.getISOCountries()).contains("DE")
    private String description;




}
