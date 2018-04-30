package com.sguess.schedule;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by PeiXingzhou on 2018-01-14.
 */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    ThreadPoolTaskScheduler scheduler;

    public ScheduleServiceImpl() {
        scheduler=new ThreadPoolTaskScheduler();
        scheduler.initialize();
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        ExecTask task=new ExecTask();
        Calendar calendar=Calendar.getInstance();
//        ScheduledFuture<ExecTask> scheduledFuture= (ScheduledFuture<ExecTask>) scheduler.schedule(task,calendar.getTime());
        ScheduledFuture<ExecTask> scheduledFuture= (ScheduledFuture<ExecTask>) scheduler.schedule(task, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger trigger=new CronTrigger("0,5,10,15,20,25,30,35,40,45,50,55 * * * * ?");
                Date nextExecuteTime=trigger.nextExecutionTime(triggerContext);
                return nextExecuteTime;
            }
        });
    }
}
