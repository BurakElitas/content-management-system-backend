package com.burak.cms.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "New")
@Entity
@Data
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "img")
    private byte[] img;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "layoutId")
    private Layout layout;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

}
