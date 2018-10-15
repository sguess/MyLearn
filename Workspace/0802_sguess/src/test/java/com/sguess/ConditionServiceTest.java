package com.sguess;

import com.sguess.condition.Condition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConditionServiceTest {
    @Autowired
    ConditionService service;

    @Test
    public void test() {
        service.test();
    }
}