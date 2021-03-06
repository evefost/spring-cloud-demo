package com.netflix.eureka.client;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.xnio.Option;
import org.xnio.Options;



@SpringBootApplication
@EnableEurekaClient
@RestController
public class Client1 {

  @Autowired
  private RestTemplate restTemplate;



  @RequestMapping("/")
  public String home() throws InterruptedException {
    Thread.sleep(500L);
    return "ok";//restTemplate.getForObject("http://eureka-client2/",String.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(Client1.class, args);
  }



//  @Bean
//  MyEurekaClient myEurekaClient(EurekaClientConfig clientConfig){
//    return new MyEurekaClient(clientConfig);
//  }
  @Bean
  UndertowBuilderCustomizer builderCustomizer(){
    return new UndertowBuilderCustomizer() {
      @Override
      public void customize(Undertow.Builder builder) {

        Option<Integer> connectionHighWater = Options.CONNECTION_HIGH_WATER;
        Option<Integer> connectionLowWater = Options.CONNECTION_LOW_WATER;
        Option<Integer> noRequestTimeout = UndertowOptions.NO_REQUEST_TIMEOUT;
        builder.setSocketOption(connectionHighWater,2);
        builder.setSocketOption(connectionLowWater,2);
        builder.setServerOption(noRequestTimeout,30*1000);
      }
    };
  }





}