/*
 * 深圳市灵智数科有限公司版权所有.
 */
package test.com.eureka.client;


import com.netflix.eureka.client.Client1;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@WebAppConfiguration("src/test/resources")
@SpringBootTest(classes = Client1.class)
public class BaseTest {

}
