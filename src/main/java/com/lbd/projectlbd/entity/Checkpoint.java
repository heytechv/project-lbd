package com.lbd.projectlbd.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "DELEGATION_CHECKLIST")
public class Checkpoint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkpoint_id") private Long checkpoint_id;
//    @Column(name = "text") private String text;
    @Column(name = "is_checked") private Boolean checked;
    @Column(name = "comment") private Boolean comment;


}
