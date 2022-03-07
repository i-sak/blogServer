package com.project.blog.controller;

import com.project.blog.model.User;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // /users 로 들어오는 모든 요청을 맞이한다.
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userid}") // 변수명이 같은 경우, @PathVariable 뒤의 변수를 제거할 수 있음
    public User getUserByUserId(@PathVariable("userid") Integer userid) {
        return userService.getUserByUserId(userid);
    }

    @PostMapping("")
    public User registUser(@RequestBody User user) {
        System.out.println(user);
        return userService.registUser(user);
    }

    @PutMapping("/{userid}") // 수정할 키, 수정할 내용은 request 본문에 넣는다.
    public void modifyUser(
            @PathVariable("userid") Integer userid,
            @RequestBody User user) {
        userService.modifyUser(user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userService.removeUser(userid);
    }

}
