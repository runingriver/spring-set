package com.hzz.service.impl;

import com.hzz.entity.User;
import com.hzz.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);

    @Resource
    UserService userService;

    @Test
    public void getAllUsers() throws Exception {
        List<User> allUsers = userService.getAllUsers();
        logger.info(allUsers.toString());
    }

    @Test
    public void getUserByUsername() throws Exception {
        User hzz = userService.getUserByUsername("hzz");
        logger.info(hzz.toString());
    }

}