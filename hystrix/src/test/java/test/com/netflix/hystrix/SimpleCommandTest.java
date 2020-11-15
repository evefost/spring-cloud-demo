package test.com.netflix.hystrix;

import com.netflix.hystrix.*;

public class SimpleCommandTest {

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            String s = new SimpleCommand(HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadpoolwithfallback"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(10)
                            .withMaximumSize(10))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(1000)
                            .withCircuitBreakerSleepWindowInMilliseconds(5000)
                            .withCircuitBreakerErrorThresholdPercentage(50)
                            .withCircuitBreakerRequestVolumeThreshold(2))
                    , "ccc", count % 20).execute();
            System.out.println(s);
            count++;
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }

    }
}