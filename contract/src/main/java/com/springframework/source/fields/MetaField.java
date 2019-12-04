package com.springframework.source.fields;

import com.springframework.source.constraints.Constraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class MetaField<T> {
    private final boolean required;
    private final String description;
    private final T defaultValue;
    private final FieldType type;
    private final List<Constraint> constraints;
}
