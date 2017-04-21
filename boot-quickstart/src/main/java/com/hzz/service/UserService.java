package com.hzz.service;

import com.hzz.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserByUsername(String name);

}
