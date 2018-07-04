package com.sguess.tmp;

import java.util.Date;
import java.util.concurrent.*;

public class Tmp01 {
    public static void main(String[] args) throws InterruptedException {
        Tmp01 tmp01 = new Tmp01();
//        tmp01.fun1();
        tmp01.fun2();
    }

    private void fun2() throws InterruptedException {
        Callable<String> callable = () -> {
            Thread.sleep(10 * 1000);
            String rst = "Finished at: " + new Date().toString();
            System.out.println(rst);
            return rst;
        };
        ExecutorService executors = Executors.newFixedThreadPool(1);
        Future<String> future = executors.submit(callable);
        System.out.println("Start to monitor : " + new Date().toString());
        int cNum = 0;
        while (true) {
            Thread.sleep(1 * 1000);
            cNum++;
            if (cNum == 5) {
                System.out.println(future.cancel(false));
            }
            System.out.println(cNum + ":\t" + future.isDone() + ",\t" + future.isCancelled());
        }

    }

    private void fun1() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);

    }
}
