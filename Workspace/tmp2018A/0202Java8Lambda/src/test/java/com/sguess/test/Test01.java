package com.sguess.test;

import java.awt.event.ActionListener;

import org.junit.Test;

public class Test01 {


    @Test
    public void test01() {
        Runnable noArguments = () -> System.out.println("Hello World");
        noArguments.run();
    }

    @Test
    public void test02() {
        ActionListener oneArgument = event -> System.out.println("button clicked");

    }
}
