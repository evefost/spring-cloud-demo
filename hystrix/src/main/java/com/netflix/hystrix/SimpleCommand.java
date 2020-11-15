package com.netflix.hystrix;

import java.util.Arrays;
import java.util.List;

public class SimpleCommand extends HystrixCommand<String> {

    public static List<Integer> times = Arrays.asList(100, 200, 300, 400, 500, 600,
            700, 800, 900, 1000, 1100, 1200, 1300, 1400, 1500, 1600, 1700, 1800, 1900, 2000, 2100);
    private String name;
    private int timeIndex;
 
    public SimpleCommand(Setter setter, String name, int timeIndex) {
        super(setter);
        this.name = name;
        this.timeIndex = timeIndex;
    }
 
    @Override
    protected String getFallback() {
        Throwable cause = getExecutionException();
        ExecuteResultType failureType = CommandSupport.getFailureType(this);
        return "fall back timeMillSeconds is :" + times.get(timeIndex)+"===="+failureType.name();
    }
 
    @Override
    protected String run() {
        try {
            Thread.currentThread().sleep(times.get(this.getTimeIndex()));
        } catch (InterruptedException e) {
        }
        return "ok timeMillSeconds is :" + times.get(timeIndex);
    }
 
    public int getTimeIndex() {
        return timeIndex;
    }
 
    public void setTimeIndex(int timeIndex) {
        this.timeIndex = timeIndex;
    }
}