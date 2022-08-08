package com.lbd.projectlbd.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Delegation")
public class Delegation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;
    @Column(name = "start_date") private Timestamp start_date;
//    @Column(name = "start_date") private Timestamp start_date;


}
