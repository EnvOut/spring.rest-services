package com.springframework.web.restservices.domain.uri;

import java.util.Optional;
import java.util.stream.Stream;

public enum Language {
    EN;

    public static Optional<Language> from(String lang) {
        return Stream.of(Language.values())
                .filter(it -> it.name().equalsIgnoreCase(lang))
                .findFirst();
    }
}
