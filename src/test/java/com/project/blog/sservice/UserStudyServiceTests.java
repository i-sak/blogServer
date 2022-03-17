package com.project.blog.sservice;

import com.project.blog.model.UserStudy;
import com.project.blog.service.UserStudyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class UserStudyServiceTests {
    @Autowired
    private UserStudyService userStudyService;

    @Test
    public void testGetUsers() {
        List<UserStudy> userStudyList = userStudyService.getUsers();

    }

}
