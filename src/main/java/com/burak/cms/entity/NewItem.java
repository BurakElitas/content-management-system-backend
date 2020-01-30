package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class NewItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "colId")
    private Col col;

    @ManyToOne
    @JoinColumn(name = "newId")
    private News news;

    private String element;


}
