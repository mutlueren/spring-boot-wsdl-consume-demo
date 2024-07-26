package com.example.demo.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingService {

	private static final Logger logger = LogManager.getLogger(LoggingService.class);

	@Pointcut("execution(* com.example.demo..*(..))")
	public void applicationPackagePointcut() {
		// Method is empty as this is just a Pointcut, the implementations are in the
		// advices.
	}

	@Before("applicationPackagePointcut()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		logger.info("Before method: " + methodName);
	}

	@After("applicationPackagePointcut()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		logger.info("After method: " + methodName);
	}

	@AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
	public void error(JoinPoint joinPoint, Throwable e) {
		String methodName = joinPoint.getSignature().getName();
		logger.error("ERROR in method: " + methodName + " - Exception: " + e.getMessage());
	}

}
