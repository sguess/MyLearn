package com.thread20180903;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Output {
    private String name;
    public int num = 1;

    public Output(String name) {
        this.name = name;

    }

    public synchronized void output1() {
        try {
            int millis = (int) (Math.random() * 1000);
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
//            num = num * 2;
//            num = num / 2;
//            num = num * 2;
//            num = num / 2;
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Output1: " + name + "\t:" + num + "\t" + new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date()));
        printNum();

    }

    public synchronized void output2() {
//        sleep();
        num = num * 2;
        num = num / 2;
        num = num * 2;
        num = num / 2;
        System.out.println("Output2: " + name + "\t:" + num + "\t" + new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date()));
        printNum();
    }

    private void printNum() {
        int val = num;
        if (val != 1) {
            System.out.println("------------------------------------------------------------------------------------------" + name + ":\t" + val + "\t" + num);
            System.out.println("------------------------------------------------------------------------------------------" + name + ":\t" + val + "\t" + num);
            System.out.println("------------------------------------------------------------------------------------------" + name + ":\t" + val + "\t" + num);
        }
    }

    public synchronized void output3() {
//        synchronized (this) {
        num = num * 2;
        num = num / 2;
        num = num * 2;
        num = num / 2;
//        }
//        sleep();
        System.out.println("Output3: " + name + "\t:" + num + "\t" + new SimpleDateFormat("yyyyMMdd hhmmss").format(new Date()));
//        System.out.print(num + "\t");

        printNum();
    }


    private void sleep() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}