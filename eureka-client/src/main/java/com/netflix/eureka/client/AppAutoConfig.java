package com.netflix.eureka.client;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppAutoConfig {

    @Bean
    RandomLoadBalancerClient randomLoadBalancerClient(DiscoveryClient discoveryClient){
        return new RandomLoadBalancerClient(discoveryClient);
    }

}
