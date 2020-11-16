package com.netflix.zuul;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.AbstractClientHttpResponse;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * 默认hystrix 降级
 *
 * @author xieyang
 */
@Component
public class DefaultFallbackProvider implements FallbackProvider {

    protected final static Logger logger = LoggerFactory.getLogger(DefaultFallbackProvider.class);

    @Override
    public String getRoute() {
        return "*";
    }


    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {

        RequestContext currentContext = RequestContext.getCurrentContext();
        logger.error("网关转失败:", cause);

        RestResult response = new RestResult();
        int status = 200;
        String message = "网络开小差！";
        response.setCode(5000);
        response.setMessage(message);
        String fallbackBody = "";
        try {
            fallbackBody = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new FallbackResponse(fallbackBody, status);
    }

    class FallbackResponse extends AbstractClientHttpResponse {

        private int status = 500;

        private String fallbackBody;

        private InputStream inputStream;

        public FallbackResponse(String fallbackBody, int status) {
            this.fallbackBody = fallbackBody;
            this.status = status;
        }

        @Override
        public HttpHeaders getHeaders() {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-type", "application/json;charset=UTF-8");
            return headers;
        }

        @Override
        public InputStream getBody() {
            inputStream = new ByteArrayInputStream(fallbackBody.getBytes(Charset.forName("UTF-8")));
            return inputStream;
        }


        @Override
        public String getStatusText() {
            return "服务有问题啦";
        }

        @Override
        public HttpStatus getStatusCode() {
            return HttpStatus.valueOf(status);
        }

        @Override
        public int getRawStatusCode() {
            return status;
        }

        @Override
        public void close() {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
