package com.danielpei.tw.ctrl;

import com.danielpei.tw.beans.Track;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"spring.profiles.active=ut"})
public class PlanningCtrlTest {

    @Autowired
    PlanningCtrl ctrl;

    @Test
    public void defaultQuestion() {
        String rst = ctrl.defaultPlan();
        System.out.println(rst);
    }
}