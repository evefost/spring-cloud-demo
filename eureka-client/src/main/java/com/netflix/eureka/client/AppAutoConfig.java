package com.netflix.eureka.client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppAutoConfig {

//    @Bean
//    RandomLoadBalancerClient randomLoadBalancerClient(DiscoveryClient discoveryClient){
//        return new RandomLoadBalancerClient(discoveryClient);
//    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Primary
    @Bean
    @ConditionalOnMissingBean(LoadBalancerClient.class)
    public GrayLoadBalancerClient loadBalancerClient(SpringClientFactory springClientFactory) {
        return new GrayLoadBalancerClient(springClientFactory);
    }



}
