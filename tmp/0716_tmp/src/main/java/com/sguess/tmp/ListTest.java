package com.sguess.tmp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ListTest {
    public static void main(String[] args){
        List<Person> list=new ArrayList<>();
        list.add(new Person("Tom01",01));
        list.add(new Person("Tom02",02));
        list.add(new Person("Tom03",03));
        list.add(new Person("Tom04",04));
        list.add(new Person("Tom05",05));
        list.add(new Person("Tom06",06));
        Stream<Person> stream = list.stream().filter((p) -> {
            return p.getAge() > 1;
        });
        Optional<Person> rst = stream.findAny();
        Optional<Person> r2 = rst.filter((p) -> {
            return p.getAge() < 1;
        });
        System.out.println(rst.get().toString());
        Person a = r2.orElse(new Person("Jerry02", 02));
        System.out.println(a);


    }

    private static void fun1(Stream<Person> stream) {
        Object[] rst = stream.toArray();
        for (Object person : rst) {
            System.out.println(person.toString());
        }
    }
}
class Person{
    private int id;
    private String name;
    private double age;

    public Person() {
    }

    public Person(String name, double age) {
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

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
