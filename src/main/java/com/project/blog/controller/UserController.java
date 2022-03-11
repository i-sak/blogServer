package com.project.blog.controller;

import com.project.blog.model.UserEntity;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService usersService;

    // getUserById
    @GetMapping("/{userId}")
    public Map<String, UserEntity> getUserByid(@PathVariable Long userId) {
        return usersService.getUserById(userId);
    }

    // selectAll Users
    @GetMapping("")
    public List<UserEntity> getAllUsers() {
        return usersService.getAllUsers();
    }

    // select User by Role
    @GetMapping("/role/{role}")
    public List<UserEntity> getUserByRole(@PathVariable String role) {
        return usersService.getUserByRole(role);
    }

    // insert User
    @PostMapping("")
    public UserEntity registUser(@RequestBody UserEntity userEntity) {
        return usersService.registUser(userEntity);
    }

    // update User
    @PutMapping("/{userId}")
    public Optional<UserEntity> modifyUser(@PathVariable Long userId, @RequestBody UserEntity userEntity) {
        return usersService.modifyUser(userId, userEntity);
    }

    // delete User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable long userId){
        usersService.deleteUser(userId);
    }




}
