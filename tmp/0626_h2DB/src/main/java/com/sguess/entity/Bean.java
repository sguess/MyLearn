package com.sguess.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "bean_tbl")
public class Bean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name1;
    @Column
    private String name2;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName1() {
        return name1;
    }


    public void setName1(String name1) {
        this.name1 = name1;
    }


    public String getName2() {
        return name2;
    }


    public void setName2(String name2) {
        this.name2 = name2;
    }


    @Override
    public String toString() {
        return "Bean [id=" + id + ", name1=" + name1 + ", name2=" + name2 + "]";
    }


}
