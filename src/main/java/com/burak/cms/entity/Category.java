package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Data
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 25,unique = true)
    private String name;
}
