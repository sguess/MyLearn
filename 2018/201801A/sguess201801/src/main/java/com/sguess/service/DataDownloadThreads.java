package com.sguess.service;

import java.util.Calendar;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DataDownloadThreads implements Runnable {

	private Calendar endTime;

	@Override
	public void run() {
			
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	
}
