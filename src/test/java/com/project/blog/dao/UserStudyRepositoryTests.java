package com.project.blog.dao;

import com.project.blog.model.UserEntity;
import com.project.blog.model.UserStudy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserStudyRepositoryTests {

    @Autowired
    private UserStudyRepository userStudyRepository;

    @Test
    public void testGetUsers() {
        List<UserStudy> userStudyList = userStudyRepository.getUsers();
        assertTrue(userStudyList.size() > 0);
    }

    @Test
    public void testGetUserByUserId() {
        UserStudy user = userStudyRepository.getUserByUserId(100);
        assertNotNull(user);
    }

}
