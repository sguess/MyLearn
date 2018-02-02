package com.sguess.service;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ScheduleService {
	private int index = 0;

	@PostConstruct
	public void init() {
		System.out.println("--------init data:" + new Date());
	}

	@Scheduled(cron = "0 0 9 * * 2-6")
	public void schedule01() {
		System.out.println(this.toString() + ": 01:" + (index++) + " :" + new Date());

	}

	@Scheduled(cron = "0 0 13 * * 2-6")
	public void schedule02() {
		Calendar endTime = Calendar.getInstance();
		endTime.set(Calendar.HOUR_OF_DAY, 15);
		endTime.set(Calendar.MINUTE, 5);
		endTime.set(Calendar.SECOND, 0);
		System.out.println("-----------------" + endTime.getTime());
		System.out.println(this.toString() + ": 02:" + (index++) + " :" + new Date());

	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 15);
		c.set(Calendar.MINUTE, 5);
		c.set(Calendar.SECOND, 0);
		System.out.println(c.before(new Date()));
		System.out.println("-----------------" + c.getTime());
	}

}
