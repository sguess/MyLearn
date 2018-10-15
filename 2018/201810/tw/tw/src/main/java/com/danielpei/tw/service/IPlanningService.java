package com.danielpei.tw.service;

import com.danielpei.tw.beans.Conference;
import com.danielpei.tw.beans.Track;

import java.util.List;

public interface IPlanningService {

    List<Track> planConference(List<Conference> conferenceList);

    void planConferenceInTrack(Track track, List<Conference> conferenceList);

    Track getANewTrackFromExistTracks(List<Track> rstList);
}
