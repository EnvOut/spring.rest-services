package com.springframework.web.restservices.domain.contract.uri;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
public class Sort {
    private final String name;
    private final SortOrder type;

    public static Sort asc(String name) {
        return of(name, SortOrder.ASC);
    }

    public static Sort desc(String name) {
        return of(name, SortOrder.DESC);
    }
}
