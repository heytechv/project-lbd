package com.lbd.projectlbd.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Comment")
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "author")
    private String author;
    @Column(name = "date")
    private Date date;
    @Column(name = "text")
    private String text;
    @ManyToOne
    @JoinColumn(name = "delegation_id",referencedColumnName = "delegation_id")
    private Delegation delegation;

    @OneToMany(mappedBy = "comment")
    private Set<Comment> comments=new HashSet<>();
    @ManyToOne
    private Comment comment;


}
