package com.hzz.dao;

import com.hzz.entity.City;
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
public class CityDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(CityDaoTest.class);

    @Resource
    CityDao cityDao;

    @Test
    public void findAll() throws Exception {
        List<City> all = cityDao.findAll();
        logger.info(all.toString());
    }

}