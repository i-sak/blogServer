package com.project.blog.controller;

import com.project.blog.annotation.TokenRequired;
import com.project.blog.model.UserStudy;
import com.project.blog.service.UserStudyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users") // /users 로 들어오는 모든 요청을 맞이한다.
public class UserStudyController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserStudyController.class);

    @Autowired
    private UserStudyService userStudyService;

    @GetMapping("")
    public List<UserStudy> getAllUsers() {
        return userStudyService.getUsers();
    }

    @GetMapping("/{userid}") // 변수명이 같은 경우, @PathVariable 뒤의 변수를 제거할 수 있음
    public UserStudy getUserByUserId(@PathVariable("userid") Integer userid) {
        logger.debug("" + userid);
        return userStudyService.getUserByUserId(userid);
    }

    @PostMapping("")
    public UserStudy registUser(@RequestBody UserStudy user) {
        System.out.println(user);
        return userStudyService.registUser(user);
    }

    @PutMapping("/{userid}") // 수정할 키, 수정할 내용은 request 본문에 넣는다.
    public void modifyUser(
            @PathVariable("userid") Integer userid,
            @RequestBody UserStudy user) {
        userStudyService.modifyUser(user);
    }

    @DeleteMapping("/{userid}")
    public void removeUser(@PathVariable Integer userid) {
        userStudyService.removeUser(userid);
    }

}
