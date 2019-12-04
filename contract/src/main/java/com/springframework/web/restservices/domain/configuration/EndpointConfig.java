package com.springframework.web.restservices.domain.configuration;

import com.springframework.web.restservices.domain.configuration.response.ResponseModel;
import com.springframework.web.restservices.domain.http.EndpointMethods;
import com.springframework.web.restservices.domain.interceptor.DefaultParameterInterceptor;
import com.springframework.web.restservices.domain.interceptor.ParameterInterceptor;
import lombok.Data;

@Data
public class EndpointConfig {
    private boolean redirect;
    private String name;
    private EndpointMethods method;
    private ParameterInterceptor interceptor = new DefaultParameterInterceptor();
    private ConfigModel model;
    private ResponseModel response;
}
