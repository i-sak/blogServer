package com.project.blog.service;

import com.project.blog.dao.UserStudyRepository;
import com.project.blog.model.UserStudy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserStudyService {

    @Autowired
    private UserStudyRepository userStudyRepository;

    public Map<String, String> getMessage() {
        Map<String, String> map = userStudyRepository.getMessage();
        return map;
    }

    public List<UserStudy> getUsers() {
        return userStudyRepository.getUsers();
    }

    public UserStudy getUserByUserId(Integer userid) {
        return userStudyRepository.getUserByUserId(userid);
    }


    public UserStudy registUser(UserStudy user) {
        return userStudyRepository.registUser(user);
    }

    public void modifyUser(UserStudy user) {
        userStudyRepository.modifyUser(user);
    }

    public void removeUser(Integer userid) {
        userStudyRepository.removeUser(userid);
    }
}
