package com.example.SpringBootMultiTenancyExample;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateHeaderModifierInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest,
                                        byte[] body,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        ClientHttpResponse response = clientHttpRequestExecution.execute(httpRequest,body);
        System.out.println("#####Headers from Interceptor######" +response.getHeaders());
        return  response;
    }
}
