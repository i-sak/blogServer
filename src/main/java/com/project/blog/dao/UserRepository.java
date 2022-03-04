package com.project.blog.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    public Map<String, String> getMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("greet","Hello world");
        return map;
    }

}
