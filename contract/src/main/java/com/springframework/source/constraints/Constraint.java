package com.springframework.source.constraints;

import com.springframework.source.fields.FieldValue;

public interface Constraint {
    <T> boolean isValid(FieldValue<T> fieldValue);
    String getMessage();
}
