package com.zq.bookstore.portal.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zq.bookstore.category.pojo.Category;
import com.zq.bookstore.category.service.CategoryService;
import com.zq.bookstore.order.pojo.Order;
import com.zq.bookstore.order.service.OrderService;

@RestController
public class PortalController {
	@Reference
	private OrderService orderService;
	@Reference
	private CategoryService categoryService;
	
	@RequestMapping("/getOrderList")
	public List<Order> getOrderist() {
		return orderService.query();
	}
	
	@RequestMapping("/getCategoryList")
	public List<Category> getCategoryList(){
		return categoryService.getCategoryList();
	}
}
