package com.sguess.learn.tmp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tmp {
    List<Cat> list;
    @Before
    public void before(){
        list=new ArrayList<>();
        list.add(new Cat("Tom",1));
        list.add(new Cat("Tom2",2));
        list.add(new Cat("Tom3",3));
        list.add(new Cat("Tom4",4));
    }

    @Test
    public void test1() {
        Stream<Cat> catStream = list.stream().filter(cat -> {
            return cat.getAge() > 2;
        });
        List<Cat> newList = catStream.collect(Collectors.toList());
        System.out.println(newList.size());
        for (Cat cat : newList) {
            System.out.println(cat);
        };
    }
    @Test
    public void test2() {
        list.add(new Cat("Tom4",4));
        Stream<Cat> stream = list.stream();
        Stream<Cat> rst = stream.distinct();
        Iterator<Cat> it = rst.iterator();
        while(it.hasNext()){
            System.out.println(String.valueOf(it.next()));
        }


    }
}
class Cat{
    private int id;
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
