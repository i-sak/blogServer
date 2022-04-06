package com.project.blog.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
@Getter
@Setter
@ToString
public class UserEntity implements Serializable {

    @Id // Auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;            // 고유값,
    @Column(name = "userId", unique = true)
    private String userId;      //
    @Column(name = "name")
    private String name;        // 이름
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType role;
}

enum RoleType {
    USER, ADMIN
}

