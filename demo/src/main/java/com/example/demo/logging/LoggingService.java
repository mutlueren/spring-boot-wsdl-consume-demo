package com.example.demo.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class LoggingService {

	private static final Logger logger = LogManager.getLogger(LoggingService.class);

	public void before(String methodName) {
		logger.info("Before method: " + methodName);
	}

	public void after(String methodName) {
		logger.info("After method: " + methodName);
	}
	
	public void error(String methodName) {
		logger.info("ERROR method: " + methodName);
	}
}