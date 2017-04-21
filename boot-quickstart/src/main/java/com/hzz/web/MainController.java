package com.hzz.web;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hzz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzz.service.UserService;

import java.util.List;

@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Resource
    UserService userService;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping(value = "/user/all")
    @ResponseBody
    public String getAllUser() {
        List<User> allUsers = userService.getAllUsers();
        String jsonString = JSON.toJSONString(allUsers);
        String jsonArrayString = JSONArray.toJSONString(allUsers);
        logger.info(jsonString);
        logger.info(jsonArrayString);
        return jsonString;
    }

}
