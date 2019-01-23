package com.zq.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "com.zq.bookstore.portal.controller")
public class PortalWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortalWebApplication.class, args);
	}
}
