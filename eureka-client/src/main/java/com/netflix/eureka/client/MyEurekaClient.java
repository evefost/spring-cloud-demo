package com.netflix.eureka.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.HealthCheckCallback;
import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.EurekaEventListener;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.discovery.shared.LookupService;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MyEurekaClient implements LookupService {


    private EurekaClient delete;

    private ObjectMapper objectMapper = new ObjectMapper();

    public MyEurekaClient(EurekaClientConfig clientConfig) {

    }



    @Override
    public Application getApplication(String appName) {

        return null;
    }

    @Override
    public Applications getApplications() {
        return null;
    }

    @Override
    public List<InstanceInfo> getInstancesById(String id) {
        return null;
    }

    @Override
    public InstanceInfo getNextServerFromEureka(String virtualHostname, boolean secure) {
        return null;
    }


}
