package com.springframework.web.restservices.domain.http;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class HttpHeader {
    private final String key;
    private final String value;
}
