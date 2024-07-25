package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.client.SoapClient;
import com.example.demo.controller.SoapController;

class SoapControllerTest {

	@Mock
	private SoapClient soapClient;

	@InjectMocks
	private SoapController soapController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testAdd() {
		when(soapClient.add(5, 3)).thenReturn(8);

		Integer result = soapController.add(5, 3);

		assertEquals(8, result);
		verify(soapClient, times(1)).add(5, 3);
	}

	@Test
	void testSubtract() {
		when(soapClient.subtract(5, 3)).thenReturn(2);

		Integer result = soapController.subtract(5, 3);

		assertEquals(2, result);
		verify(soapClient, times(1)).subtract(5, 3);
	}

	@Test
	void testMultiply() {
		when(soapClient.multiply(5, 3)).thenReturn(15);

		Integer result = soapController.multiply(5, 3);

		assertEquals(15, result);
		verify(soapClient, times(1)).multiply(5, 3);
	}

	@Test
	void testDivide() throws Exception {
		when(soapClient.divide(6, 3)).thenReturn(2);

		Integer result = soapController.divide(6, 3);

		assertEquals(2, result);
		verify(soapClient, times(1)).divide(6, 3);
	}
}
