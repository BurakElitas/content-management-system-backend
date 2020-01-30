package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table
@Data
public class Row implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "layout_id")
    private Layout layout;

    @Column(name = "displayNumber",nullable = false)
    private int displayNumber;

}
