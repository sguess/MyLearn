package com.sguess.ctrl;



import javax.validation.constraints.NotNull;

import static org.junit.Assert.*;

public class ApiCtrlTest {
    public void funTest(@NotNull String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        ApiCtrlTest test = new ApiCtrlTest();
        test.funTest(null);
        test.funTest("Hello");
    }
}