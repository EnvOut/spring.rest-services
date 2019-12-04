package com.springframework.web.restservices.domain.configuration.request;

import com.springframework.web.restservices.domain.interceptor.ParameterInterceptor;
import lombok.Data;

@Data
public class EndpointRequestConfig {
    private int maxParamsCount = 0;
    private ParameterInterceptor interceptor;
}
