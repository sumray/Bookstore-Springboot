package com.zq.bookstore.portal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.RegistryConfig;

@Configuration
public class PortalDubboConfig {
    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("bookstore-portal-web");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://192.168.25.128:2181");
        return registryConfig;
    }

    @Bean
    public MonitorConfig monitorConfig() {
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");
        return monitorConfig;
    }
    
//    /**
//     * 订单dubbo接口
//     * @param applicationConfig
//     * @param registryConfig
//     * @param monitorConfig
//     * @return
//     */
//    @Bean
//    public ReferenceConfig<OrderService> referenceConfig(ApplicationConfig applicationConfig, RegistryConfig registryConfig,
//                                                  MonitorConfig monitorConfig) {
//        ReferenceConfig<OrderService> referenceConfig = new ReferenceConfig<>();
//        referenceConfig.setApplication(applicationConfig);
//        referenceConfig.setRegistry(registryConfig);
//        referenceConfig.setMonitor(monitorConfig);
//        referenceConfig.setInterface(OrderService.class);
//        referenceConfig.setTimeout(5000);
//        referenceConfig.setRetries(0);
//        return referenceConfig;
//    }
//
//    @Bean
//    public ReferenceConfigCache referenceConfigCache() {
//        ReferenceConfigCache referenceConfigCache = ReferenceConfigCache.getCache();
//        return referenceConfigCache;
//    }
//
//    @Bean
//    public OrderService orderService(ReferenceConfigCache referenceConfigCache, ReferenceConfig<OrderService> referenceConfig) {
//        return referenceConfigCache.get(referenceConfig);
//    }
    
}
