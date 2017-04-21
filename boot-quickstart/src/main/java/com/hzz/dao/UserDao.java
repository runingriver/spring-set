package com.hzz.dao;

import com.hzz.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> getAllUser();

    User selectUserByName(@Param("name") String name);

}
