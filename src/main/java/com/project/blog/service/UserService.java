package com.project.blog.service;

import com.project.blog.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, String> getMessage() {
        Map<String, String> map = userRepository.getMessage();
        return map;
    }

}
