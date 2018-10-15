package com.thread20180905;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread implements Runnable {
    private Output output;
    public MyThread(Output output) {
        this.output = output;
    }
    @Override
    public void run() {
        Output output = new Output();
        output.output();
    }
    public static void main(String[] args) {
        Output output = new Output();
        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread(output)).start();
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("wait...");
        }
    }
}

class Output {

    public  int num = 0;

    public synchronized void output() {
//        synchronized (Output.class) {
            num++;
            sleep();
//        }
        System.out.println("Output: " + num);
    }
    private void sleep() {
        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}