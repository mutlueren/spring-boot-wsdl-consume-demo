package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.logging.LoggingService;

@ExtendWith(MockitoExtension.class)
public class LoggingServiceTest {

    @Mock
    private Logger logger;

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Signature signature;

    @InjectMocks
    private LoggingService loggingService;

    @BeforeEach
    public void setUp() {
        Mockito.when(joinPoint.getSignature()).thenReturn(signature);
        Mockito.when(signature.getName()).thenReturn("testMethod");
    }

    @Test
    public void testBefore() {
        loggingService.before(joinPoint);

        assertNotNull(loggingService);
    }

    @Test
    public void testAfter() {
        loggingService.after(joinPoint);

        assertNotNull(loggingService);
    }

    @Test
    public void testError() {
        Throwable throwable = new RuntimeException("Exception message");
        loggingService.error(joinPoint, throwable);

        assertNotNull(loggingService);
    }
}