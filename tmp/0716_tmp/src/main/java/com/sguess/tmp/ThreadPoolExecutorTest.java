package com.sguess.tmp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest test = new ThreadPoolExecutorTest();
        test.test01();
    }

    private void test01() throws InterruptedException {
        LinkedBlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1, TimeUnit.SECONDS, workQueue);
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.err.println(executor.getQueue().size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Future<String> rsts = executor.submit(new Th1("Th" + i));
            list.add(rsts);
            BlockingQueue<Runnable> queue = executor.getQueue();
            System.out.println(i + ":\t" + queue.size());
            Thread.sleep(500);
        }
        new Thread(()->{
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Iterator<Future<String>> it = list.iterator();
                StringBuffer sb=new StringBuffer("------->");
                while(it.hasNext()){

                    Future<String> next = it.next();
                    if (next.isDone()){
                        try {
                            String rst = next.get();
                            sb.append(rst+",\t");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println(sb.toString());
            }
        }).start();
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
