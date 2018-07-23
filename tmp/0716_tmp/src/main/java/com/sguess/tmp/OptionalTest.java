package com.sguess.tmp;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args){
        new OptionalTest().fun01();
    }

    private void fun01() {
//        Optional<Stu> ops=new Optional<Stu>();
    }
}
class Stu{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
