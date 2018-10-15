package com.sguess.dao.entity;

import javax.persistence.*;

@Table(name = "mock_tbl")
@Entity
public class MockEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private MockType mockType;

    public MockEntity() {
    }

    public MockEntity(String name, int age) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MockType getMockType() {
        return mockType;
    }

    public void setMockType(MockType mockType) {
        this.mockType = mockType;
    }
}
