package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Col {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "row_id")
    private Row row;

    @Column(name = "colSize")
    private int colSize;

    @Column(name = "displayNumber",nullable = false)
    private int displayNumber;

}
