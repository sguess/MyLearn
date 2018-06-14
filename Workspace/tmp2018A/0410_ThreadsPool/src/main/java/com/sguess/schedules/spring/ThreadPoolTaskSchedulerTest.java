package com.sguess.schedules.spring;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class ThreadPoolTaskSchedulerTest {

	public static void main(String[] args) {
		ThreadPoolTaskScheduler scheduler=new ThreadPoolTaskScheduler();
		scheduler.initialize();
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
	}

}
