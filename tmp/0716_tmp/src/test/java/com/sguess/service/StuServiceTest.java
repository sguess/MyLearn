package com.sguess.service;

import com.sguess.dao.entity.StuEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StuServiceTest {
    @Autowired
    StuService service;

    @Test
    public void test1() {
        StuEntity stuEntity=new StuEntity("Tom", new Date());
        service.save(stuEntity);
    }
}