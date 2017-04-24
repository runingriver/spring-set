package com.hzz.web;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hzz.common.ApplicationConfig;
import com.hzz.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hzz.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Resource
    UserService userService;

    @Value("${app.message.hello}")
    private String hello;

    @Resource
    ApplicationConfig configuration;

    @RequestMapping("/hello")
    public String index(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.hello);
        return "welcome";
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

    @GetMapping(value = "/app")
    public String appConfig() {
        return "the app config:" + configuration.getName();
    }

    @GetMapping(value = "/get")
    public String getMethod() {
        return "application properties value:" + hello;
    }

    @PostMapping(value = "/post")
    public String postMethod() {
        return "application properties value:" + hello;
    }

}
