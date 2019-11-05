package com.springframework.web.restservices.domain.contract.uri;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Page {
    private final Integer page;
    private final Integer size;
}
