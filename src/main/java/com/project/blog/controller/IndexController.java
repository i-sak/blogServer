package com.project.blog.controller;

import com.project.blog.service.SecurityService;
import com.project.blog.service.SecurityServiceImpl;
import com.project.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

// 스프링 MVC에서 Controller는 요청을 맞이해서 분석하여 응답하는 역할을 한다.
// @Controller
@RestController
@RequestMapping("/")
public class IndexController {  // 요청을 제일 먼저 맞이하는 것이 Controller

    @Autowired(required = true)
    private SecurityServiceImpl securityService;
    //private UserService userService;

    //@RequestMapping(value="/", method = RequestMethod.GET)
    //@ResponseBody
    @GetMapping("")
    public String index() { // home
        return "hello world. Isaac Blog API Server";
    }

    // token 발행
    @GetMapping("security/generate/token")
    public Map<String, Object> generateToken(@RequestParam String subject) {
        String token = securityService.createToken(subject , 1000 * 60 * 60);
        Map<String, Object > map = new HashMap<>();
        map.put("userid", subject);
        map.put("token", token);
        return map;
    }
    // token 요청 (식별)
    @GetMapping("security/get/subject")
    public String getSubject(@RequestParam String token) {
        String subject = securityService.getSubject(token);
        return subject;
    }

}
