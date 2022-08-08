package com.lbd.projectlbd.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "DELEGATION_CHECKLIST")
@Data
public class Checkpoint {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checkpoint_id") private Long id;
    @Column(name = "is_checked")    private Boolean isChecked;
    @Column(name = "comment")       private String comment;
    //    @Column(name = "text") private String text;

    @OneToOne
    @JoinColumn(name = "delegation_id")
    private Delegation delegation;



}
