package com.sguess;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private ApplicationContext app;

    @PostConstruct
    public void init() {
        fun01();
    }

    @Scheduled(fixedDelay = 1000)
    public void fun01() {
        OneTask task = app.getBean(OneTask.class);
        task.output();
    }
}
