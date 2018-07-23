package com.sguess.bean;

import java.util.Date;

public class PrBean {
    private int id;
    private Date time;
    private int value;

    public PrBean() {
    }

    public PrBean(Date time, int value) {
        this.time = time;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
