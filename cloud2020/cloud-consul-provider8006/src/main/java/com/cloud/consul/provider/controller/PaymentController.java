package com.cloud.consul.provider.controller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/consul")
    public String paymentzk() {
    	return "springcloude with consul:" +serverPort+"\t" 
    										+ UUID.randomUUID().toString();
    }
}