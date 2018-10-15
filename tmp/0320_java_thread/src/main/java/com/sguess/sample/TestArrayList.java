package com.sguess.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class TestArrayList {
    private static int i = 0;
    private static List<Integer> list = new ArrayList<>();
//    private static Vector<Integer> list = new Vector<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            testList();
//            list.clear();
        }
    }

    private static void testList() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                list.add(i);
            }
            System.err.println((i++) + ":" + list.size());
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();

//        t1.join();
//        t2.join();
//        t3.join();

//        System.out.println(i+":"+list.size());
    }
}
