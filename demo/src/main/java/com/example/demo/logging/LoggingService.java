package com.example.demo.logging;

import java.util.Arrays;
import java.util.List;

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

	@Pointcut("execution(* com.example.demo.client..*(..))")
	public void configPackagePointcut() {
	    // pointcut tanımı olarak işlev görür ve genellikle boş bırakılır çünkü kendisi bir "ad" veya "etiket" sağlar, Aspect loglama yapılacak paket burada tanıtılır
	}

	@Before("configPackagePointcut()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.info("Before method: " + methodName + " - First Arg: " + argsList.get(0) + " - Second Arg: " + argsList.get(1));
	}

	@After("configPackagePointcut()")
	public void after(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.info("After method: " + methodName + " - First Arg: " + argsList.get(0) + " - Second Arg: " + argsList.get(1));
	}

	@AfterThrowing(pointcut = "configPackagePointcut()", throwing = "e")
	public void error(JoinPoint joinPoint, Throwable e) {
		String methodName = joinPoint.getSignature().getName();		
		List<Object> argsList = Arrays.asList(joinPoint.getArgs());
		logger.error("ERROR in method: " + methodName + " - First Arg: " + argsList.get(0) + " - Second Arg: " + argsList.get(1));
	}
}
