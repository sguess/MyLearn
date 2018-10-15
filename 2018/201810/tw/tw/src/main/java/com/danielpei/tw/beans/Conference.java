package com.danielpei.tw.beans;

import java.util.Date;


public class Conference implements Comparable<Conference> {
    //Conference name
    private String name;
    // The duration time of conference, the time unit is milliseconds.
    private long duration;
    //The conference start time.
    private Date startTime;
    //The conference type, normal, lightning, lunch time, or networking event
    private ConferenceType type;
    // init the status value.
    private ConferenceStatus status = ConferenceStatus.NOT_ASSIGNED;
    //Original String, It is come form the input file.
    private String originStr;

    public Conference() {
    }

    public Conference(String name, long duration) {
        this.name = name;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setType(ConferenceType type) {
        this.type = type;
    }

    public ConferenceType getType() {
        return type;
    }

    @Override
    public int compareTo(Conference o) {
        if (this.getDuration() > o.getDuration()) {
            return -1;
        } else if (this.getDuration() < o.getDuration()) {
            return 1;
        } else
            return 0;
    }

    public ConferenceStatus getStatus() {
        return status;
    }

    public void setStatus(ConferenceStatus status) {
        this.status = status;
    }

    public String getOriginStr() {
        return originStr;
    }

    public void setOriginStr(String originStr) {
        this.originStr = originStr;
    }

    @Override
    public String toString() {
        return "Conference{" +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", startTime=" + startTime +
                ", type=" + type +
                ", status=" + status +
                ", originStr='" + originStr + '\'' +
                '}';
    }
}
