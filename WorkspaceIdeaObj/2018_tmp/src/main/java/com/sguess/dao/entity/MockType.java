package com.sguess.dao.entity;

public enum MockType {
    real("real"),mock("mock");

    private String mockStr;

   MockType(String mockStr) {
        this.mockStr = mockStr;
    }
}
