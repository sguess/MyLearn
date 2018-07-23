package com.sguess.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduleService {

	@PostConstruct
	public void init() {
		System.out.println("--------init data:" + new Date());
	}

	@Scheduled(fixedDelay = 1000)
	public void schedule01() {
		System.out.println(this.toString() + " :" + new Date());

	}

}
