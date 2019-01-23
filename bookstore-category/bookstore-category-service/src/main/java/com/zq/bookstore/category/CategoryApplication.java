package com.zq.bookstore.category;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.zq.bookstore.category.service.impl")
public class CategoryApplication {
	public static void main(String[] args) {
		SpringApplication.run(CategoryApplication.class, args);
	}
}
