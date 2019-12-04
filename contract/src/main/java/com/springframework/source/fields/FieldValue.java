package com.springframework.source.fields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FieldValue<T> {
    private final MetaField<T> meta;
    private final T value;
}
