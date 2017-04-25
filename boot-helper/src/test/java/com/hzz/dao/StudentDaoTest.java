package com.hzz.dao;

import com.hzz.entity.Student;
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
public class StudentDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(StudentDaoTest.class);

    @Resource
    StudentDao studentDao;

    @Test
    public void findAll() throws Exception {
        List<Student> all = studentDao.findAll();
        logger.info(all.toString());
    }

    @Test
    public void findStudentByName() {
        Student zhangsan = studentDao.findStudentByName("zhangsan");
        logger.info(zhangsan.toString());
    }

    @Test
    public void countByName() {
        long count = studentDao.countByName("zhangsan");
        logger.info("{}", count);
    }
}