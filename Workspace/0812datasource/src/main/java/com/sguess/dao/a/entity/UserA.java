package com.sguess.dao.a.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
public class UserA {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String age;

    public UserA() {
    }

    public UserA(String name, String age) {
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
