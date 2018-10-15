package com.sguess.dao.impl;

import static org.junit.Assert.*;

import com.sguess.dao.IMockDao;
import com.sguess.dao.entity.MockEntity;
import com.sguess.dao.entity.MockType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=ut"})
public class MockDaoImplTest {
    @Autowired
    IMockDao dao;

    @Test
    public void test() {
        MockEntity entity = new MockEntity();
        entity.setAge(10);
        entity.setName("Tom");
        entity.setMockType(MockType.mock);
        dao.save(entity);
    }

}