package com.sguess.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IBeanServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    IBeanService beanService;

    @Autowired
    @Qualifier("bean01")
    IBeanService bean01Service;

    @Autowired
    @Qualifier("bean02")
    IBeanService bean02Service;

    @Test
    public void printInfo() {
        IBeanService bean01 = (IBeanService) applicationContext.getBean("bean01");
        IBeanService bean02 = (IBeanService) applicationContext.getBean("bean02");
        bean01.printInfo();
        bean02.printInfo();
        applicationContext.getBean(IBeanService.class).printInfo();
    }

    @Test
    public void printInfoThroughAutowired() {
        beanService.printInfo();
        bean01Service.printInfo();
        bean02Service.printInfo();
    }
}