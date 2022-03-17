package com.project.blog.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//@ExtendWith(MockitoExtension.class), @ExtendWith(SpringExtension.class) 모두 가능
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class UserStudyMockMVCTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUserIntroduction() throws Exception {
        String content = "test";

        mockMvc.perform(
                MockMvcRequestBuilders.get("/users/100")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(content().string("안녕하세요."))
                .andDo(print());
    }

    /*
    강의용 예제

    @Autowired
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before("")
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).build();
    }

    @Test
    public void testBasicMVC() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("result", status().is(200)))
                .andReturn();
        String content = result.getResponse().getContentAsString();
        System.out.println("{testBasicMVC} response : " + content);
    }
    */

}

