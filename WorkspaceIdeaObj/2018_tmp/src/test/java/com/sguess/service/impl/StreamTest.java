package com.sguess.service.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Tom", true));
        list.add(new Person(2, "Tom2", true));
        list.add(new Person(3, "Tom3", false));
        list.add(new Person(4, "Tom4", true));
        list.add(new Person(5, "Tom5", false));
        list.add(new Person(6, "Tom6", true));
        Iterator<Person> it = list.stream().filter((person -> person.sex)).iterator();
        while (it.hasNext()) {
            Person next = it.next();
            System.out.println(next);
        }
        System.out.println("----------------------------------------------");
        list=list.stream().filter((person -> person.sex)).collect(Collectors.toList());
        for (Person person : list) {
            System.out.println(person);
        }

    }

    static class Person {
        private int id;
        private String name;
        private boolean sex;

        public Person() {
        }

        public Person(int id, String name, boolean sex) {
            this.id = id;
            this.name = name;
            this.sex = sex;
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

        public boolean isSex() {
            return sex;
        }

        public void setSex(boolean sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sex=" + sex +
                    '}';
        }
    }
}
