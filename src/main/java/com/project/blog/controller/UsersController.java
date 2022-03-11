package com.project.blog.controller;

import com.project.blog.model.UserEntity;
import com.project.blog.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    // getUserById
    @GetMapping("/{userId}")
    public Map<String, UserEntity> getUserByid(@PathVariable Long userId) {
        return usersService.getUserById(userId);
    }

    // selectAll User

    // select User by Role

    // insert User

    // update User

    // delete User




}
