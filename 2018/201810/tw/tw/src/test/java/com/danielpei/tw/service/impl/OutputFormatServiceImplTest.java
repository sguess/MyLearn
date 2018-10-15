package com.danielpei.tw.service.impl;

import static org.junit.Assert.*;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.Track;
import com.danielpei.tw.beans.TrackType;
import com.danielpei.tw.service.IOutputFormatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=ut"})
public class OutputFormatServiceImplTest {
    @Autowired
    IOutputFormatService service;

    @Test
    public void testOutPut() throws ParseException {
        List<Track> trackList = new ArrayList<>();
        trackList.add(getTrack(0, TrackType.MORNING, "0900", "1000"));
        trackList.add(getTrack(0, TrackType.AFTERNOON, "1300", "1400"));
        trackList.add(getTrack(1, TrackType.MORNING, "0900", "1000"));
        trackList.add(getTrack(1, TrackType.AFTERNOON, "1300", "1400"));
        String rstStr = service.formatTrack(trackList);
        System.out.println(rstStr);
        assertTrue(rstStr.contains("09:00AM a 60min"));
        assertTrue(rstStr.contains("02:00PM b 60min"));
        assertTrue(rstStr.contains("Track 2"));
    }

    private Track getTrack(int day, TrackType trackType, String conf01StartTimeStr, String conf02StartTimeStr) throws ParseException {
        Track track1=new Track();
        track1.setDay(day);
        track1.setType(trackType);
        List<Conference> confDay1MorningList=new ArrayList<>();
        Conference conf01=new Conference();
        conf01.setStartTime(new SimpleDateFormat("HHmm").parse(conf01StartTimeStr));
        conf01.setOriginStr("a 60min");
        confDay1MorningList.add(conf01);
        Conference conf02=new Conference();
        conf02.setStartTime(new SimpleDateFormat("HHmm").parse(conf02StartTimeStr));
        conf02.setOriginStr("b 60min");
        confDay1MorningList.add(conf02);
        track1.setConferenceList(confDay1MorningList);
        track1.setConferenceList(confDay1MorningList);
        return track1;
    }
}