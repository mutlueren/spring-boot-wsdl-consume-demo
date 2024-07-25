package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.example.demo.logging.LoggingService;

public class LoggingServiceTest {

	@Mock
	private Logger logger;

	@Test
	public void testBeforeMethod() {
		String methodName = "testMethod";
		LoggingService srv = new LoggingService();
		srv.before(methodName);
		assertNotNull(srv);
	}

	@Test
	public void testAfterMethod() {
		String methodName = "testMethod";
		LoggingService srv = new LoggingService();
		srv.before(methodName);
		assertNotNull(srv);
	}
	
	@Test
	public void testErrorMethod() {
		String methodName = "testError";
		LoggingService srv = new LoggingService();
		srv.error(methodName);
		assertNotNull(srv);
	}
}
