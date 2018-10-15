package com.danielpei.tw.service.impl;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.ConferenceStatus;
import com.danielpei.tw.beans.Track;
import com.danielpei.tw.beans.TrackType;
import com.danielpei.tw.common.Constants;
import com.danielpei.tw.service.IPlanningService;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"spring.profiles.active=ut"})
public class PlanningServiceImplTest {

    @Autowired
    IPlanningService service;

    @Test
    public void planConference() {
        List<Conference> confList = new ArrayList<>();
        confList.add(new Conference("a", 1));
        confList.add(new Conference("b", 2));
        confList.add(new Conference("c", 5));
        confList.add(new Conference("d", 3));
        List<Track> rst = service.planConference(confList);
        for (Track track : rst) {
            System.out.println(track.toString());
        }
    }

    @Test
    public void getANewTrackFromExistTracks() {
        List<Track> trackList = new ArrayList<>();
        Track track1Morning = service.getANewTrackFromExistTracks(trackList);
        assertEquals(0, track1Morning.getDay());
        assertEquals(TrackType.MORNING, track1Morning.getType());
        assertEquals(3 * 60 * 60 * 1000, track1Morning.getCapacity());
        trackList.add(track1Morning);
        Track track1Afternoon = service.getANewTrackFromExistTracks(trackList);
        assertEquals(0, track1Afternoon.getDay());
        assertEquals(TrackType.AFTERNOON, track1Afternoon.getType());
        assertEquals(4 * 60 * 60 * 1000, track1Afternoon.getCapacity());
        trackList.add(track1Afternoon);

    }

    @Test
    public void testPlanConferenceInTrackForMorning() {
        Track track = service.getANewTrackFromExistTracks(new ArrayList<>());
        List<Conference> conferenceList = new ArrayList<>();
        conferenceList.add(new Conference("a", 60 * 60 * 1000));
        conferenceList.add(new Conference("b", 30 * 60 * 1000));
        conferenceList.add(new Conference("c", 60 * 60 * 1000));
        conferenceList.add(new Conference("d", 60 * 60 * 1000));
        conferenceList.add(new Conference("e", 60 * 60 * 1000));
        service.planConferenceInTrack(track, conferenceList);
        assertEquals("09:00", getTimeStr(conferenceList.get(0).getStartTime()));
        assertEquals("10:00", getTimeStr(conferenceList.get(1).getStartTime()));
        assertEquals("10:30", getTimeStr(conferenceList.get(2).getStartTime()));
        assertEquals("", getTimeStr(conferenceList.get(3).getStartTime()));
        assertEquals("", getTimeStr(conferenceList.get(4).getStartTime()));
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(0).getStatus());
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(1).getStatus());
        assertEquals(ConferenceStatus.NOT_ASSIGNED, conferenceList.get(3).getStatus());
        assertEquals(ConferenceStatus.NOT_ASSIGNED, conferenceList.get(4).getStatus());
        List<Conference> assignedConfList = track.getConferenceList();
        assertEquals(Constants.LUNCH, assignedConfList.get(assignedConfList.size() - 1).getName());
        assertEquals("12:00", getTimeStr(assignedConfList.get(assignedConfList.size() - 1).getStartTime()));
    }

    @Test
    public void testPlanConferenceInTrackForAfternoon() {
        ArrayList<Track> rstList = new ArrayList<>();
        rstList.add(new Track());
        Track track = service.getANewTrackFromExistTracks(rstList);
        List<Conference> conferenceList = new ArrayList<>();
        conferenceList.add(new Conference("a", 60 * 60 * 1000));
        conferenceList.add(new Conference("b", 30 * 60 * 1000));
        conferenceList.add(new Conference("c", 60 * 60 * 1000));
        conferenceList.add(new Conference("d", 60 * 60 * 1000));
        conferenceList.add(new Conference("e", 60 * 60 * 1000));
        conferenceList.add(new Conference("f", 60 * 60 * 1000));
        service.planConferenceInTrack(track, conferenceList);
        assertEquals("13:00", getTimeStr(conferenceList.get(0).getStartTime()));
        assertEquals("14:00", getTimeStr(conferenceList.get(1).getStartTime()));
        assertEquals("14:30", getTimeStr(conferenceList.get(2).getStartTime()));
        assertEquals("15:30", getTimeStr(conferenceList.get(3).getStartTime()));
        assertEquals("", getTimeStr(conferenceList.get(4).getStartTime()));
        assertEquals("", getTimeStr(conferenceList.get(5).getStartTime()));
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(0).getStatus());
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(1).getStatus());
        assertEquals(ConferenceStatus.NOT_ASSIGNED, conferenceList.get(4).getStatus());
        assertEquals(ConferenceStatus.NOT_ASSIGNED, conferenceList.get(5).getStatus());
        List<Conference> assignedConfList = track.getConferenceList();
        assertEquals(Constants.NETWORKING_EVENT, assignedConfList.get(assignedConfList.size() - 1).getName());
        assertEquals("16:30", getTimeStr(assignedConfList.get(assignedConfList.size() - 1).getStartTime()));
    }

    @Test
    public void testPlanConferenceInTrackForAfternoonWhenOnlyAFewConference() {
        ArrayList<Track> rstList = new ArrayList<>();
        rstList.add(new Track());
        Track track = service.getANewTrackFromExistTracks(rstList);
        List<Conference> conferenceList = new ArrayList<>();
        conferenceList.add(new Conference("a", 60 * 60 * 1000));
        conferenceList.add(new Conference("b", 30 * 60 * 1000));
        service.planConferenceInTrack(track, conferenceList);
        assertEquals("13:00", getTimeStr(conferenceList.get(0).getStartTime()));
        assertEquals("14:00", getTimeStr(conferenceList.get(1).getStartTime()));
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(0).getStatus());
        assertEquals(ConferenceStatus.ASSIGNED, conferenceList.get(1).getStatus());
        List<Conference> assignedConfList = track.getConferenceList();
        assertEquals(Constants.NETWORKING_EVENT, assignedConfList.get(assignedConfList.size() - 1).getName());
        assertEquals("16:00", getTimeStr(assignedConfList.get(assignedConfList.size() - 1).getStartTime()));
    }

    private String getTimeStr(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            return sdf.format(date);
        } catch (Exception e) {
            return "";
        }
    }
}
