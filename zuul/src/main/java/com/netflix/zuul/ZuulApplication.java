/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.netflix.zuul;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication(scanBasePackages = {"com.netflix.zuul"})
@EnableZuulProxy
//@EnableZuulServer
//@EnableEurekaClient
@EnableDiscoveryClient
public class ZuulApplication {
    protected static final Logger logger = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        logger.info("ZuulApplication start successfully...");
    }

}
