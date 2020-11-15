package com.netflix.hystrix;


import org.slf4j.MDC;

/**
 * 熔断器监听器
 *
 * @author xie
 */
public interface CommandListener {


    /**
     * 命令建创建
     *
     * @param commandInfo
     */
    default void onCommandCreate(CommandInfo commandInfo) {
        commandInfo.setProperty("uuid", MDC.get("uuid"));
    }

    /**
     * 开始
     */
    void onStart(CommandInfo commandInfo);


    /**
     * 成功回调
     */
    default void onSuccess(CommandInfo commandInfo) {
    }


    /**
     * 失败回调
     *
     * @param commandInfo
     */
    default void onFailure(CommandInfo commandInfo) {
    }


    /**
     * 熔断器打开（粒度为接口级）
     */
    default void onCircuitBreakerOpen(CommandInfo commandInfo) {
    }


    /**
     * 熔断器关闭 （粒度为接口级）
     */
    default void onCircuitBreakerClose(CommandInfo commandInfo) {
    }


    default void onComplete(CommandInfo commandInfo) {


    }


}
