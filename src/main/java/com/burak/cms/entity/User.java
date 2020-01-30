package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Column;
import java.io.Serializable;

@Table
@Entity
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,length = 25)
    private String name;

    @Column(name = "surname",length = 25)
    private String surname;

    @Column(name = "password",nullable = false)
    private String password;
}
