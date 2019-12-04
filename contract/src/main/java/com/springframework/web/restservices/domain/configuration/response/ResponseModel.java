package com.springframework.web.restservices.domain.configuration.response;

import com.springframework.web.restservices.domain.configuration.ConfigModel;
import com.springframework.web.restservices.domain.http.HttpHeader;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ResponseModel {
    private final List<HttpHeader> headers;
    private final ConfigModel model;
}
