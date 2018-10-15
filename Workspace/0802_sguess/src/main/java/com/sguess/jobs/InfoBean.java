package com.sguess.jobs;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class InfoBean {
    @JsonIgnore
    private int id;
    private String code;
    private String name;
    private int value;


    public InfoBean() {
    }

    public InfoBean(String code, String name, int value) {
        this.code = code;
        this.name = name;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getValue() {
//        return value;
//    }

    //    public void setValue(int value) {
//        this.value = value;
//    }
    private String va;

    //    public void setTemp(String tmp){
//        va="Hello";
//    }
    public String getTemp1() {
        return "Tmp";
    }

    @Override
    public String toString() {
        return "InfoBean{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                ", va='" + va + '\'' +
                '}';
    }
}
