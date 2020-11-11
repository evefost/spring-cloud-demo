package com.netflix.eureka.client;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Random;

public class RandomLoadBalancerClient implements LoadBalancerClient {
    
    private RestTemplate restTemplate = new RestTemplate();
    
    private DiscoveryClient discoveryClient;
    Random random = new Random();

    public RandomLoadBalancerClient(DiscoveryClient discoveryClient){
        this.discoveryClient = discoveryClient;
    }
    
    @Override
    public <T> T execute(String serviceId, LoadBalancerRequest<T> request) throws IOException {
        
        return null;
    }

    @Override
    public <T> T execute(String serviceId, ServiceInstance serviceInstance, LoadBalancerRequest<T> request) throws IOException {
        return null;
    }

    @Override
    public URI reconstructURI(ServiceInstance instance, URI original) {
        return null;
    }



    @Override
    public ServiceInstance choose(String serviceId) {
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if(instances == null || instances.isEmpty()){
            throw new RuntimeException("没找到服务"+serviceId+"实例");
        }
        ServiceInstance serviceInstance = instances.get(random.nextInt(instances.size()));
        return serviceInstance;
    }
}
