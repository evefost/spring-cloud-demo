package test.com.eureka.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.eureka.client.MyEurekaClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DiscoverClientTest extends BaseTest{

    @Autowired
    private EurekaClient lookupService;

    @Autowired
    private MyEurekaClient myEurekaClient;
;

    @Test
    public void getApplication(){
        Application application = lookupService.getApplication("eureka-client2");
        assert application != null;
        List<InstanceInfo> instances = application.getInstances();
        for(InstanceInfo instanceInfo:instances){
            System.out.println("实例信息:"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort());
        }
    }


    @Test
    public void getApplicationByMyClient(){
        Application application = myEurekaClient.getApplication("eureka-client2");
        assert application != null;
        List<InstanceInfo> instances = application.getInstances();
        for(InstanceInfo instanceInfo:instances){
            System.out.println("实例信息:"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort());
        }
    }
}
