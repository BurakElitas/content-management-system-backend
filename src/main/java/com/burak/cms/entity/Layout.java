package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "Layout")
@Data
public class Layout implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;



}
