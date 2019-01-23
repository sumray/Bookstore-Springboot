package com.zq.bookstore.category.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class CategoryDubboConfig {
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig config = new ApplicationConfig();
		config.setName("bookstore-category-service");
		return config;
	}
	
	@Bean
	public RegistryConfig registerConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setAddress("zookeeper://192.168.25.128:2181");
		return config;
	}
	
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig config = new ProtocolConfig();
		config.setName("dubbo");
		config.setPort(20881);
		return config;
	}
	
	@Bean
	public MonitorConfig monitorConfig() {
		MonitorConfig config = new MonitorConfig();
		config.setProtocol("registry");
		return config;
	}
	
}
