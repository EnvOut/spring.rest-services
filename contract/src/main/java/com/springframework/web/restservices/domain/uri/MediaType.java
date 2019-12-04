package com.springframework.web.restservices.domain.uri;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public enum MediaType {
    JSON(Arrays.asList("json"));

    private final List<String> extensions;

    public static Optional<MediaType> find(String extension) {
        return Stream.of(values()).filter(it -> it.extensions.contains(extension))
                .findFirst();
    }
}
