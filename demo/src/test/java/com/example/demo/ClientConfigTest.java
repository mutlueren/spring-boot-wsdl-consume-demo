package com.example.demo;

import com.example.demo.client.SoapClient;
import com.example.demo.config.ClientConfig;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(ClientConfig.class)
public class ClientConfigTest {

	@Test
	public void testMarshaller() {
		ClientConfig clientConfig = new ClientConfig();

		Jaxb2Marshaller marshaller = clientConfig.marshaller();
		assertNotNull(marshaller);
		assertEquals("com.example.demo.schemas", marshaller.getContextPath());
	}

	@Test
	public void testSoapClient() {
		Jaxb2Marshaller mockMarshaller = Mockito.mock(Jaxb2Marshaller.class);

		ClientConfig clientConfig = new ClientConfig();

		SoapClient soapClient = clientConfig.soapClient(mockMarshaller);

		assertNotNull(soapClient);
		assertEquals("http://www.dneonline.com/calculator.asmx", soapClient.getDefaultUri());
		assertEquals(mockMarshaller, soapClient.getMarshaller());
		assertEquals(mockMarshaller, soapClient.getUnmarshaller());
	}
}
