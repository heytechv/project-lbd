package com.lbd.projectlbd.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Entity
@Data
@Table(name = "DELEGATION")
public class Delegation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "begin_date") private Timestamp startDate;
    @Column(name = "end_date") private Timestamp endDate;
    @Column(name = "first_name") private String name;
    @Column(name = "last_name") private String lastname;
    @Column(name = "city") private String city;
    @Column(name = "country") private Locale countryCode;  // Arrays.asList(Locale.getISOCountries()).contains("DE")
    @Column(name = "description") private String description ;

    @OneToMany(mappedBy = "delegation")
    private Set<Comment> commentSet = new HashSet<>();

}
