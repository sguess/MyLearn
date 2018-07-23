package com.sguess.service;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.stereotype.Service;

@Service
public class OutputService {
	private Log LOG = LogFactory.getLog(OutputService.class);
	private Logger LOGGER = LoggerFactory.getLogger(OutputService.class);

	@PostConstruct
	public void printLog() throws InterruptedException {
		LOGGER.debug("-----------org.slf4j.Logger.debug");
		LOGGER.info("-----------org.slf4j.Logger.info");
		LOGGER.warn("-----------org.slf4j.Logger.warn");
		LOGGER.error("-----------org.slf4j.Logger.error");
		LOGGER.trace("-----------org.slf4j.Logger.trace");
		LOG.info("--------org.apache.commons.logging.Log");
	}
}