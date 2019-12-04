package com.springframework.source.constraints;

import com.springframework.source.fields.FieldValue;

public class IsNull extends AbstractConstraint {
    @Override
    public <T> boolean isValid(FieldValue<T> fieldValue) {
        return fieldValue.getValue() == null;
    }
}
