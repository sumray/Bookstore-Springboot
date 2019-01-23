package com.zq.bookstore.order.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.alibaba.dubbo.config.annotation.Service;
import com.zq.bookstore.order.pojo.Order;
import com.zq.bookstore.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Override
	public List<Order> query() {
		List<Order> list = new ArrayList<Order>();
		Order o = new Order();
		o.setOid(1);
		o.setOname("你好");
		list.add(o);
		return list;
	}
}
