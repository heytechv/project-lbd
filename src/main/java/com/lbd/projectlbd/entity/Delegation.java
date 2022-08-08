package com.lbd.projectlbd.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Locale;

@Entity
@Table(name = "Delegation")
public class Delegation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "start_date") private Timestamp start_date;
    @Column(name = "end_date") private Timestamp end_date;
    @Column(name = "name") private String name;
    @Column(name = "surname") private String surname;
    @Column(name = "city") private String city;
    @Column(name = "country_code") private Locale country_code;  // Arrays.asList(Locale.getISOCountries()).contains("DE")
    @Column(name = "info") private String info;

}
