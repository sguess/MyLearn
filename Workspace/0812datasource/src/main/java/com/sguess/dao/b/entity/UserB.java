package com.sguess.dao.b.entity;

import javax.persistence.*;

import javax.persistence.Entity;

@Entity
@Table(name = "user")
public class UserB {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String age;

    public UserB() {
    }

    public UserB(String name, String age) {
        this.name = name;
        this.age = age;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
