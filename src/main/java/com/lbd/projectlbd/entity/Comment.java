package com.lbd.projectlbd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "COMMENT")
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")      private Long id;
    @Column(name = "author")  private String author;
    @Column(name = "date")    private Date date;
    @Column(name = "content") private String text;

    @ManyToOne
    @JoinColumn(name = "delegation_id")
    private Delegation delegation;

    @OneToMany(mappedBy = "comment")
    private Set<Comment> commentSet = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment comment;


}
