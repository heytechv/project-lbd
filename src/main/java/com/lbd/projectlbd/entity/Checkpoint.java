package com.lbd.projectlbd.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "Checkpoint")
public class Checkpoint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private Long id;



}
