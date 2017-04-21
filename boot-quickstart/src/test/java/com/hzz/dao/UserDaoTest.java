package com.hzz.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hzz.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);

    @Resource
    UserDao userDao;

    @Test
    public void getAllUser() throws Exception {
        List<User> allUser = userDao.getAllUser();
        logger.info(allUser.toString());
    }

    @Test
    public void selectUserByName() throws Exception {
        User hzz = userDao.selectUserByName("hzz");
        logger.info(hzz.toString());
    }

}