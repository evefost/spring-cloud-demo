package test.com.eureka.client;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RibbonTest extends BaseTest{


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private SpringClientFactory factory;


//    @Autowired
    private RibbonLoadBalancerClient loadBalancingHttpClient;

    @Autowired
    LoadBalancerRequestFactory requestFactory;
    @Test
    public void testRibbon() throws InterruptedException {

        while (true){
            try {
                String result = restTemplate.getForObject("http://eureka-client2/", String.class);
                System.out.println("结果===:"+result);
            }catch (Exception e){
                e.printStackTrace();
            }

            Thread.sleep(3000);
        }
    }

    @Test
    public void testLoadBalancer() throws InterruptedException {
        while (true){
            try {
                ILoadBalancer loadBalancer = factory.getLoadBalancer("eureka-client2");
                Server server = loadBalancer.chooseServer(null);
                System.out.println(server.getId());
            }catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(3000);
        }

    }

    @Test
    public void testRibbonClient() throws IOException {
        LoadBalancerClient instance = factory.getInstance("eureka-client2", LoadBalancerClient.class);
        instance.execute("eureka-client2",new LoadBalancerRequest<String>() {
            @Override
            public String apply(ServiceInstance instance) throws Exception {
                return null;
            }
        });
    }

}
