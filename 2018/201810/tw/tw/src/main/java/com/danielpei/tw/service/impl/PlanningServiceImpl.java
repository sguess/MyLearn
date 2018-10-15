package com.danielpei.tw.service.impl;

import com.danielpei.tw.beans.*;
import com.danielpei.tw.service.IPlanningService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.danielpei.tw.common.Constants.LUNCH;
import static com.danielpei.tw.common.Constants.NETWORKING_EVENT;

@Service
public class PlanningServiceImpl implements IPlanningService {
    private static final Logger LOG = LoggerFactory.getLogger(PlanningServiceImpl.class);
    @Value("${time.track.track.lunch.hour}")
    int lunchHour = 12;
    @Value("${time.track.track.morning.start.hour}")
    int trackMorningStartHour = 9;
    @Value("${time.track.track.morning.end.hour}")
    int trackMorningEndHour = 12;
    @Value("${time.track.track.afternoon.start.hour}")
    int trackAfternoonStartHour = 13;
    @Value("${time.track.track.afternoon.end.hour}")
    int trackAfternoonEndHour = 17;
    @Value("${time.track.track.afternoon.early.end.hour}")
    int trackAfternoonEarlyEndHour = 16;


    /**
     * This is the planning conference follow logic.
     *
     * @param conferenceList
     * @return
     */
    @Override
    public List<Track> planConference(List<Conference> conferenceList) {
        if (conferenceList == null || conferenceList.isEmpty()) {
            LOG.error("The conference is empty!");
            return new ArrayList<>();
        }
        LOG.info("The conf size is " + conferenceList.size());
        List<Track> rstList = new ArrayList<>();
        while (!isAssignedAllConference(conferenceList)) {
            LOG.info("Generate a new Track for assign the un-assigned conference");
            Track track = getANewTrackFromExistTracks(rstList);
            LOG.info("The new track is " + track.toString());
            conferenceList.sort(Conference::compareTo);
            planConferenceInTrack(track, conferenceList);
            rstList.add(track);
        }
        LOG.info("ALl conferences are assigned");
        return rstList;
    }

    private boolean isAssignedAllConference(List<Conference> conferenceList) {
        for (Conference conference : conferenceList) {
            if (conference.getStatus() == ConferenceStatus.NOT_ASSIGNED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void planConferenceInTrack(Track track, List<Conference> conferenceList) {
        for (Conference conference : conferenceList) {
            if (conference.getStatus() == ConferenceStatus.ASSIGNED) {
                continue;
            }
            if (track.getCapacity() >= conference.getDuration()) {
                LOG.info("Assign " + conference.getName() + " on track " + track.getId());
                conference.setStatus(ConferenceStatus.ASSIGNED);
                conference.setStartTime(track.getCurrentAssignedTime());
                track.getConferenceList().add(conference);
                track.setCapacity(track.getCapacity() - conference.getDuration());
                track.setCurrentAssignedTime(new Date(track.getCurrentAssignedTime().getTime() + conference.getDuration()));
            }
        }
        LOG.info("Start to plan lunch or network event on " + track.getType().toString());
        if (track.getType() == TrackType.MORNING) {
            Conference conference = new Conference();
            conference.setOriginStr(LUNCH);
            Calendar lunchTime = Calendar.getInstance();
            lunchTime.set(Calendar.HOUR_OF_DAY, lunchHour);
            lunchTime.set(Calendar.MINUTE, 0);
            lunchTime.set(Calendar.MILLISECOND, 0);
            conference.setStartTime(lunchTime.getTime());
            conference.setStatus(ConferenceStatus.ASSIGNED);
            conference.setType(ConferenceType.LUNCH);
            conference.setName(LUNCH);
            track.getConferenceList().add(conference);
        } else {
            Conference conference = new Conference();
            conference.setOriginStr(NETWORKING_EVENT);
            Calendar c = Calendar.getInstance();
            c.setTime(track.getCurrentAssignedTime());

            if (c.get(Calendar.HOUR_OF_DAY) < trackAfternoonEarlyEndHour) {
                Calendar networkEventTime = Calendar.getInstance();
                networkEventTime.set(Calendar.HOUR_OF_DAY, trackAfternoonEarlyEndHour);
                networkEventTime.set(Calendar.MINUTE, 0);
                networkEventTime.set(Calendar.MILLISECOND, 0);
                conference.setStartTime(networkEventTime.getTime());
            } else {
                conference.setStartTime(track.getCurrentAssignedTime());
            }
            conference.setStatus(ConferenceStatus.ASSIGNED);
            conference.setType(ConferenceType.NETWORKING_EVENT);
            conference.setName(NETWORKING_EVENT);
            track.getConferenceList().add(conference);
        }

    }

    @Override
    public Track getANewTrackFromExistTracks(List<Track> rstList) {
        Track track = new Track();
        track.setId(rstList.size());
        track.setDay(track.getId() / 2);
        track.setType(TrackType.valueOf(track.getId() % 2));
        Calendar starttime = Calendar.getInstance();
        starttime.set(Calendar.MINUTE, 0);
        starttime.set(Calendar.SECOND, 0);
        starttime.set(Calendar.MILLISECOND, 0);
        Calendar endtime = Calendar.getInstance();
        endtime.set(Calendar.MINUTE, 0);
        endtime.set(Calendar.SECOND, 0);
        endtime.set(Calendar.MILLISECOND, 0);
        if (track.getId() % 2 == 0) {
            starttime.set(Calendar.HOUR_OF_DAY, trackMorningStartHour);
            track.setStartTime(starttime.getTime());
            endtime.set(Calendar.HOUR_OF_DAY, trackMorningEndHour);
            track.setStartTime(endtime.getTime());
        } else {
            starttime.set(Calendar.HOUR_OF_DAY, trackAfternoonStartHour);
            track.setStartTime(starttime.getTime());
            endtime.set(Calendar.HOUR_OF_DAY, trackAfternoonEndHour);
            track.setStartTime(endtime.getTime());
        }
        track.setCapacity(endtime.getTimeInMillis() - starttime.getTimeInMillis());
        track.setCurrentAssignedTime(starttime.getTime());
        return track;
    }

}
