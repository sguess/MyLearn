package com.sguess;

import java.util.Date;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Date startDate = new Date();
        System.out.println("Start: " + startDate);
        for (int i = 0; i < 100_000; i++) {
            new Thread(new MyThreads()).start();
        }
        Date endDate = new Date();
        System.out.println("End: " + endDate);
        System.out.println(endDate.getTime() - startDate.getTime());
    }
}

class MyThreads implements Runnable {
    static int i = 0;

    @Override
    public void run() {
        i = 0;
        i = i + 1;
        if (i == 0 || i > 1) {
            try {
                Thread.sleep(new Random().nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Error: " + i);
        }
    }
}




