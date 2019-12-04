package com.springframework.source.constraints;

import com.springframework.source.fields.FieldType;
import com.springframework.source.fields.FieldValue;

import java.util.Optional;

public class AssertFalse extends AbstractConstraint {

    @Override
    public <T> boolean isValid(FieldValue<T> fieldValue) {
        return Optional.ofNullable(fieldValue)
                .filter(f -> f.getMeta().getType() == FieldType.BOOLEAN)
                .map(FieldValue::getValue)
                .filter(v -> (Boolean) v)
                .isPresent();
    }
}
