package com.hzz.web;

import com.hzz.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(MainControllerTest.class);

    private UserService userService;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }


    @Test
    public void index() throws Exception {
        this.mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    public void getAllUser() throws Exception {
        /*jsonPath:https://github.com/json-path/JsonPath*/
        /*org.hamcrest.Matchers表示匹配方法*/
        this.mvc.perform(get("/user/all"))
                .andExpect(status().isOk())
                /*json返回内容是数组*/
                .andExpect(jsonPath("$..*").isArray())
                /*json数组长度为2*/
                .andExpect(jsonPath("$[*]", hasSize(2)));
    }

}