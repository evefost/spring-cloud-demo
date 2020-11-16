/*
 * 深圳市灵智数科有限公司版权所有.
 */
package com.netflix.zuul;



import java.io.Serializable;


public class RestResult<T> implements Serializable {
    /**
     * 编码
     */
    protected long code;
    /**
     * 消息
     */
    protected String message;
    /**
     * 时间戳
     */
    protected Long timestamp;
    /**
     * 返回数据对象
     */
    protected T data;

    public RestResult() {
        this.code = 200;
        this.message = "ok";
        this.timestamp = System.currentTimeMillis();
    }

    private RestResult(Builder<T> builder) {
        this.timestamp = System.currentTimeMillis();
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RestResult<T> code(long code) {
        this.code = code;
        return this;
    }

    public RestResult<T> message(String message) {
        this.message = message;
        return this;
    }

    public RestResult<T> putTimestamp() {
        this.timestamp = System.currentTimeMillis();
        return this;
    }

    public RestResult<T> data(T data) {
        this.data = data;
        return this;
    }

    public static class Builder<T> {
        /**
         * 编码
         */
        private long code = 200;
        /**
         * 消息
         */
        private String message;
        /**
         * 返回数据对象
         */
        private T data;

        public Builder code(long code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public RestResult<T> build() {
            RestResult<T> restResult = new RestResult(this);
            return restResult;
        }
    }
}
