package com.sguess.eureka.client.ctrl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=ut"})
public class HelloCtrlTest {

    @Autowired
    HelloCtrl ctrl;

    @Autowired
    DiscoveryClient client;
    @Test
    public void test1() {

    }
}