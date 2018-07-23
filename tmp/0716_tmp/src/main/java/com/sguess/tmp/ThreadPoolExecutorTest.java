package com.sguess.tmp;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest test = new ThreadPoolExecutorTest();
        test.test01();
    }

    private void test01() throws InterruptedException {
        LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, workQueue);
        new Thread(){
            @Override
            public void run() {
                while(true){
                    System.err.println(executor.getQueue().size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        for (int i = 0; i < 20; i++) {
            executor.submit(new Th("Th" + i));
            StringBuffer sb = new StringBuffer();
            BlockingQueue<Runnable> queue = executor.getQueue();
//            for (Runnable runnable : queue) {
//                sb.append(runnable.getClass().getName()).append(",\t");

//            }
            System.out.println(i+":\t"+queue.size());
//            System.out.println(sb.toString());
            Thread.sleep(500);
        }

    }

    class Th implements Runnable {

        private String name;

        public Th(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    class Th1 implements Callable<String> {

        private String name;

        public Th1(String name) {
            this.name = name;
        }


        @Override
        public String call() throws Exception {
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.name;
        }
    }
}
