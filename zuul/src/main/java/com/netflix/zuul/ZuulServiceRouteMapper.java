package com.netflix.zuul;

import org.springframework.cloud.netflix.zuul.filters.discovery.ServiceRouteMapper;
import org.springframework.stereotype.Component;

/**
 * 服务路由转换
 */
@Component
public class ZuulServiceRouteMapper implements ServiceRouteMapper {
    @Override
    public String apply(String serviceId) {
        return serviceId;//"aaaaaa";
    }
}
