package com.netflix.hystrix;


public class MockCommand extends HystrixCommand<Object> {

    private  long executeTime;

    private boolean throwException;

    public MockCommand(Setter setter, long executeTime, boolean throwException) {
        super(setter);
        this.executeTime = executeTime;
        this.throwException = throwException;
    }

    @Override
    protected Object run() throws Exception {
        if(throwException){
            throw new RuntimeException("模拟执行失败");
        }
        try {
            Thread.sleep(executeTime);
        } catch (InterruptedException e) {
        }
        return "execute ok time:"+executeTime;
    }

    @Override
    protected String getFallback() {
        ExecuteResultType failureType = CommandSupport.getFailureType(this);
        return "fall back timeMillSeconds is :" + executeTime+"===="+failureType.name();
    }
}
