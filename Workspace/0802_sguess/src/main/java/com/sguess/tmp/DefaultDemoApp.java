package com.sguess.tmp;

public class DefaultDemoApp {
    public static void main(String[] args) {
        new ClassA().defaultFunction();
        new ClassAB().defaultFunction();
    }
}

interface InterA {
    default void defaultFunction() {
        System.out.println("This is A defaultFunction");
    }

    static void staticFunction() {
        System.out.println("This is A status function");
    }
}

interface InterB {
    default void defaultFunction() {
        System.out.println("This is B defaultFunction");
    }

    static void staticFunction() {
        System.out.println("This is B status function");
    }
}

class ClassA implements InterA {

}

class ClassAB implements InterA, InterB {
    @Override
    public void defaultFunction() {
        InterB.staticFunction();
    }
}


