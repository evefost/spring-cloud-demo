package test.com.eureka.client;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.ribbon.apache.RibbonLoadBalancingHttpClient;
import org.springframework.web.client.RestTemplate;

public class RibbonTest extends BaseTest{


    @Autowired
    private RestTemplate restTemplate;



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

    @Autowired
    private SpringClientFactory factory;

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

}
