package com.project.blog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="menu")
@Getter
@Setter
public class MenuEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(length = 100)
    private String name;

    @Column
    private Long parentMenuId;
    @Column
    private int level;
}
