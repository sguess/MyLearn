package com.sguess.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;


@EnableScheduling
@Service
public class ScheduleProcess {

    @Scheduled(cron = "* 35 9 * * *")
    public void schedule() {
        new Thread(() -> {
            int number = (int) (Math.random() * 100);
            System.out.println(number + ",Start\t" + new Date().toString());
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(number + ",End\t" + new Date().toString());
        }).start();
    }
}
