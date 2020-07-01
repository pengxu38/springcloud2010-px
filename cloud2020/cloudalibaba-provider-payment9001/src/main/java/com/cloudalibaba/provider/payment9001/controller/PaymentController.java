package com.cloudalibaba.provider.payment9001.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    
    @Value("${server.port}")
    private String serverPort;
    
	@GetMapping(value="/payment/nacos/{id}")
	public String zipkin(@PathVariable("id") Integer id) {
		return "nacos registry " + serverPort +"\t id " + id;
	}
	
}
