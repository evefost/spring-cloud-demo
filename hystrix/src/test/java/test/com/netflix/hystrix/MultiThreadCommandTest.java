package test.com.netflix.hystrix;

import com.lingzhi.dubhe.test.MultiThreadTestUtils;
import com.lingzhi.dubhe.test.TestResult;
import com.netflix.hystrix.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class MultiThreadCommandTest {

    boolean[] failureArr = {true, false, false, true, true, false};

    /**
     * 线程池方式隔离资源
     * 1.设置固定的执行时间，不模拟执行报错
     * 2.调整请求流量观察 hystrix运作动
     *
     * @throws InterruptedException
     */
    @Test
    public void testThreadWithFixTime() throws InterruptedException {
        TestResult execute = MultiThreadTestUtils.execute(100, 1000, 100000, 30, new Runnable() {
            @Override
            public void run() {
                Object result = buildCommand(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD,1000,false).execute();
                System.out.println("任务结果:"+result );
            }
        });
        System.out.println("失败任务数:" + execute.getThrowableList().size());
        assert execute.getThrowableList().size() == 0;
    }

    /**
     * 模拟随机时间和执行失败
     * 观察 hystrix 表现
     * @throws InterruptedException
     */
    @Test
    public void testThreadWithRandomTimeAndException() throws InterruptedException {
        TestResult execute = MultiThreadTestUtils.execute(100, 1000, 100000, 25, new Runnable() {
            @Override
            public void run() {
                Object result = buildCommand(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD,mockExecuteTime(),mockThrowExcepton()).execute();
                System.out.println("任务结果:"+result );
            }
        });
        System.out.println("失败任务数:" + execute.getThrowableList().size());
        assert execute.getThrowableList().size() == 0;
    }

    /**
     * @throws InterruptedException
     */
    @Test
    public void testSEMAPHORE() throws InterruptedException {
        TestResult execute = MultiThreadTestUtils.execute(100, 1000, 50000, 25, new Runnable() {
            @Override
            public void run() {
                Object result = buildCommand(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE,mockExecuteTime(),mockThrowExcepton()).execute();
                System.out.println("任务结果:" + result);
            }
        });
        System.out.println("失败任务数:" + execute.getThrowableList().size());
        assert execute.getThrowableList().size() == 0;
    }

    /**
     * 构建执行命令
     *
     * @param strategy
     * @return
     */
    private MockCommand buildCommand(HystrixCommandProperties.ExecutionIsolationStrategy strategy, int executeTime, boolean throwException) {
        HystrixCommand.Setter setter = HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("testCommand"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        //配置线程池并发
                        .withCoreSize(25)
                        .withMaximumSize(25))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withMetricsRollingStatisticalWindowInMilliseconds(60000)
                        .withExecutionTimeoutInMilliseconds(1010)
                        .withCircuitBreakerSleepWindowInMilliseconds(2000)
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withCircuitBreakerRequestVolumeThreshold(5)
                        .withExecutionIsolationStrategy(strategy)
                        //配置信号量并发
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(11)
                );
        MockCommand testCommand = new MockCommand(setter, executeTime, throwException);
        return testCommand;
    }

    Random random = new Random();

    private int mockExecuteTime() {
        return random.nextInt(550) + 700;
    }

    /**
     * //模拟是否执行成功(抛异常表示失败)
     *
     * @return
     */
    private boolean mockThrowExcepton() {
        boolean throwEx = failureArr[random.nextInt(failureArr.length)];
        return throwEx;
    }


}
