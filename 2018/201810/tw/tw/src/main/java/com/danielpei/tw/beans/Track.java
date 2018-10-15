package com.danielpei.tw.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//a half day is one track.
public class Track {
    //The id start at 0, the index of the track,
    private int id;
    private int day;
    private TrackType type;
    //The track capacity.
    private long capacity;
    private List<Conference> conferenceList;
    private Date startTime;
    private Date currentAssignedTime;

    public  long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Conference> getConferenceList() {
        if (conferenceList==null){
            conferenceList=new ArrayList<>();
        }
        return conferenceList;
    }

    public void setConferenceList(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }

    public TrackType getType() {
        return type;
    }

    public void setType(TrackType type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setCurrentAssignedTime(Date currentAssignedTime) {
        this.currentAssignedTime = currentAssignedTime;
    }

    public Date getCurrentAssignedTime() {
        return currentAssignedTime;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", day=" + day +
                ", type=" + type +
                ", capacity=" + capacity +
                ", conferenceList=" + conferenceList +
                ", startTime=" + startTime +
                ", currentAssignedTime=" + currentAssignedTime +
                '}';
    }
}
