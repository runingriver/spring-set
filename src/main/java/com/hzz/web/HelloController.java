package com.hzz.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "hello")
    public String sayHello() {
        return "hello spring boot";
    }

}
