package com.cloudalibaba.consumer.sevice;

import com.cloudalibaba.consumer.domain.Order;

public interface OrderService {
	void create(Order order);
	void update(Long userId,Integer status);
}
