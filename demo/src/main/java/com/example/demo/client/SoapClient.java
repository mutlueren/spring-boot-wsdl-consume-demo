package com.example.demo.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.demo.schemas.Add;
import com.example.demo.schemas.AddResponse;
import com.example.demo.schemas.Divide;
import com.example.demo.schemas.DivideResponse;
import com.example.demo.schemas.Multiply;
import com.example.demo.schemas.MultiplyResponse;
import com.example.demo.schemas.Subtract;
import com.example.demo.schemas.SubtractResponse;

public class SoapClient extends WebServiceGatewaySupport {

	public Integer add(int num1, int num2) {
		Add request = new Add();
		request.setIntA(num1);
		request.setIntB(num2);
		AddResponse response = (AddResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(), request,
				new SoapActionCallback("http://tempuri.org/Add"));
		return response.getAddResult();
	}

	public Integer subtract(int num1, int num2) {
		Subtract request = new Subtract();
		request.setIntA(num1);
		request.setIntB(num2);
		SubtractResponse response = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(),
				request, new SoapActionCallback("http://tempuri.org/Subtract"));
		return response.getSubtractResult();
	}

	public Integer multiply(int num1, int num2) {
		Multiply request = new Multiply();
		request.setIntA(num1);
		request.setIntB(num2);
		MultiplyResponse response = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(),
				request, new SoapActionCallback("http://tempuri.org/Multiply"));
		return response.getMultiplyResult();
	}

	public Integer divide(int num1, int num2) throws Exception {
		if (num2 == 0) {
			throw new Exception("Divider must not be zero!");
		}
		Divide request = new Divide();
		request.setIntA(num1);
		request.setIntB(num2);
		DivideResponse response = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive(getDefaultUri(),
				request, new SoapActionCallback("http://tempuri.org/Divide"));
		return response.getDivideResult();
	}
}
