package com.sguess.sample;

public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new TestThread("a");
        Thread t2 = new TestThread("b");
        Thread t3 = new TestThread("c");
        Thread t4 = new TestThread("d");

        t1.start();
        t2.start();
        t2.join();
        t3.start();
        t4.start();
        for (int i = 0; i < 100; i++) {
            Thread t = new TestThread(String.valueOf(i));
            t.start();
            if (i % 10 == 0) {
                t.join(10_000);
            }
        }
    }


    static class TestThread extends Thread {
        private String name;

        public TestThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Start the thread " + name);
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("End the thread " + name);
        }
    }
}
