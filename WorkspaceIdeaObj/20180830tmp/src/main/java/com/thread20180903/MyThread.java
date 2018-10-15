package com.thread20180903;

public class MyThread implements Runnable {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }


    @Override
    public void run() {

        Output output = new Output(name);
        if (Integer.valueOf(name) % 3 == 0) {
            output.output3();
        } else if (Integer.valueOf(name) % 3 == 1) {
            output.output1();
        } else if (Integer.valueOf(name) % 3 == 2) {
            output.output2();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(new MyThread(String.valueOf(finalI))).start();
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