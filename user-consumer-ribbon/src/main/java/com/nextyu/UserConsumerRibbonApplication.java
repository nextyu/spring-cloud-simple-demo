package com.nextyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 使用@EnableCircuitBreaker注解开启断路器功能
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class UserConsumerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerRibbonApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
