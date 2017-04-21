package com.hzz.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzz.dao.UserDao;
import com.hzz.entity.User;
import com.hzz.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        List<User> allUser = userDao.getAllUser();
        return allUser;
    }

    @Override
    public User getUserByUsername(String name) {
        User user = userDao.selectUserByName(name);
        return user;
    }
}
