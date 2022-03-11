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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "name")
    private String userName;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType role;
}

enum RoleType {
    USER, ADMIN
}

