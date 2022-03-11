package com.project.blog.service;

import com.project.blog.dao.UsersRepository;
import com.project.blog.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public Map<String, UserEntity> getUserById(Long userId) {
        UserEntity userEntity = usersRepository.findById(userId).orElse(null);
        Map<String, UserEntity> map = new HashMap<>();
        map.put("user", userEntity);
        return map;
    }

}
