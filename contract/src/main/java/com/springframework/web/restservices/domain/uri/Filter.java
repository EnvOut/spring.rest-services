package com.springframework.web.restservices.domain.uri;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Filter {
    private final String name;
    private final String value;
}
