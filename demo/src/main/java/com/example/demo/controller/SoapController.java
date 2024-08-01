package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.client.SoapClient;

@RestController
public class SoapController {

	@Autowired
	private SoapClient soapClient;

	@GetMapping("/add")
	public Integer add(@RequestParam Integer num1, @RequestParam Integer num2) {
		return soapClient.add(num1, num2);
	}

	@GetMapping("/subtract")
	public Integer subtract(@RequestParam Integer num1, @RequestParam Integer num2) {
		return soapClient.subtract(num1, num2);
	}

	@GetMapping("/multiply")
	public Integer multiply(@RequestParam Integer num1, @RequestParam Integer num2) {
		return soapClient.multiply(num1, num2);
	}

	@GetMapping("/divide")
	public Integer divide(@RequestParam Integer num1, @RequestParam Integer num2) throws Exception {
		return soapClient.divide(num1, num2);
	}
}
