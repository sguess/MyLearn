package com.danielpei.tw.service.impl;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.exception.ConferenceException;
import com.danielpei.tw.service.IParseService;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=ut"})
public class ParseServiceImplTest {

    @Autowired
    IParseService service;

    @Test
    public void parseDefaultData() throws ConferenceException {
        List<Conference> rst = service.parseDefaultData();
        for (Conference conference : rst) {
            System.out.println(conference.toString());
        }
    }

    @Test
    public void parseConerenceFromStr() throws ConferenceException {
        String nameStr = "Writing Fast Tests Against Enterprise Rails";
        int durationMins = 60;
        String str = nameStr + " " + durationMins + "min";
        Conference con = service.parseConferenceFromStr(str);
        assertEquals(nameStr, con.getName());
        assertEquals(durationMins * 60 * 1000, con.getDuration());

        Conference con2 = service.parseConferenceFromStr("a 1min");
        assertEquals("a", con2.getName());
        assertEquals(1 * 60 * 1000, con2.getDuration());
    }

    @Test(expected = ConferenceException.class)
    public void parseConerenceFromStrExpectException() throws ConferenceException {
        String nameStr = "a";
        int durationMins = 6000;
        String str = nameStr + " " + durationMins + "min";
        service.parseConferenceFromStr(str);
    }

    @Test
    public void testParseDefaultDataFromInputList() throws ConferenceException {
        List<String> list = new ArrayList();
        list.add("a 1min");
        list.add("b 2min");
        list.add("c 3min");
        list.add("d 4min");
        List<Conference> rst = service.parseDefaultDataFromInputList(list);
        assertEquals(4, rst.size());
        Conference conf0 = rst.get(0);
        assertEquals("a 1min", conf0.getOriginStr());
        assertEquals(1 * 60 * 1000, conf0.getDuration());
        assertEquals("a", conf0.getName());
    }


}