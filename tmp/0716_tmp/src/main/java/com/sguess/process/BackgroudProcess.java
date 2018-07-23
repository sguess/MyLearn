package com.sguess.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class BackgroudProcess {
    Logger log = LoggerFactory.getLogger(BackgroudProcess.class);
    ThreadPoolExecutor executorService;
    List<Future<String>> list;

    public void init() {
        executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        list = new ArrayList<>();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        new BackgroudProcess().execute();
    }

    private void execute() throws InterruptedException, ExecutionException {
        init();
        monitor();
        submit();

    }

    private void monitor() throws InterruptedException, ExecutionException {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("ThreadPoolInfo: Active:" + executorService.getActiveCount() + ",\t coreSize: " + executorService.getCorePoolSize());
                    for (Future<String> future : list) {
                        log.info("future status is Cancelled: " + future.isCancelled() + ", is Done: " + future.isDone());
                        if (future.isDone()) {

                            try {
                                log.info("------------------------------------------------------------ done:" + future.get());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }

            }
        }.start();

    }

    private void submit() {

        for (int i = 0; i < 10; i++) {
            CThread cthread = new CThread("Tom" + i);
            Future<String> rst = executorService.submit(cthread);
            list.add(rst);
        }
    }
}

class CThread implements Callable<String> {
    private String name;

    public CThread() {
    }

    public CThread(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(5*1000);
        return "Hello," + name;
    }
}
