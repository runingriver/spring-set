package com.hzz.web;

import com.hzz.entity.City;
import com.hzz.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//RestController=Controller + ResponseBody
@RestController
public class CityController {
    private static final Logger logger = LoggerFactory.getLogger(CityController.class);

    @Resource
    CityService cityService;

    @RequestMapping(value = "/user/all")
    public String getAllUser() {
        List<City> allCity = cityService.getAllCity();
        return allCity.toString();
    }


}
