package com.cloudalibaba.consumer.controller;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entites.CommonResult;
import com.atguigu.springcloud.entites.Payment;
import com.cloudalibaba.consumer.myhandler.CustomerBlockHandler;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RateLimitController {
	
	@GetMapping("/byResource")
	@SentinelResource(value="byResource",blockHandler="handleException")
	public CommonResult byResource() {
		return new CommonResult(200,"按照资源名称限流测试",new Payment(2020L,"serial001"));
	}
	
	public CommonResult handleException(BlockException exception) {
		return new CommonResult(444, exception.getClass().getCanonicalName()+"\t 服务不可用");
	}
	
	@GetMapping("/rateLimit/byUrl")
	@SentinelResource(value="byUrl")
	public CommonResult byUrl() {
		return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial001"));
	}
	
	@GetMapping("/rateLimit/customerBlockHandler")
	@SentinelResource(value="customerBlockHandler",
				blockHandlerClass=CustomerBlockHandler.class,
				blockHandler="handlerException2")
	public CommonResult customerBlockHandler() {
		return new CommonResult(200,"按客户自定义",new Payment(2020L,"serial001"));
	}
	
}
