package com.sguess.dao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name="student")
public class StuEntity {
    @GeneratedValue
    @Id
    private Long id;

    @Column
    private String name;

    @Column
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyyMMdd HHmmss")
    private Date time;

    public StuEntity() {
    }

    public StuEntity(String name, Date time) {
        this.name = name;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "StuEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
