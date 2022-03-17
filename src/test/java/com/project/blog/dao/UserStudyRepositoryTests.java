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
        // 이 메소드가 정상적인지를 판단한다.
        List<UserStudy> userStudyList = userStudyRepository.getUsers();
        // 단정 메서드로 확인
        assertTrue(userStudyList.size() > 0);
    }

    @Test
    public void testGetUserByUserId() {
        UserStudy user = userStudyRepository.getUserByUserId(100);
        assertNotNull(user);
    }

}
