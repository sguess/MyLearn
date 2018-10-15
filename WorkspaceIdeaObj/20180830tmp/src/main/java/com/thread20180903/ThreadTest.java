package com.thread20180903;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 300, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        List<Future<String>> rstList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            rstList.add(threadPoolExecutor.submit(new MyCall("a" + i)));
        }
        new Thread(() -> {
            while (true) {
                System.out.print("Start -->" + new Date().toString());
                for (Future<String> future : rstList) {
                    System.out.print(future.isDone() + "\t:");
                }
                System.out.println("<--END");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("--------------------END2-------------");

            }


        }).start();
        for (Future<String> future : rstList) {
            try {
                System.out.println("2:" + future.isCancelled() + ",\t" + future.isDone() + ",\t" + future.get(2, TimeUnit.SECONDS));
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

    }


    static class MyCall implements Callable<String> {
        private String name;

        public MyCall(String name) {
            this.name = name;
        }


        @Override
        public String call() throws Exception {
            System.out.println(name + " Start call...");
            try {
                Thread.sleep(1 * 10 * 1000);
            } catch (InterruptedException e) {
                return name + ", Exception,";
            }
            System.out.println(name + " End call...");
            return name + ", End & Finished";
        }

    }


}
