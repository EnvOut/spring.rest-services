package com.springframework.web.restservices.domain.contract.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.UUID;

@UtilityClass
public class IdentifierUtils {
    public boolean isDigits(String text) {
        return NumberUtils.isDigits(text);
    }

    public boolean isUUID(String text) {
        UUID uuid = null;
        try {
            uuid = UUID.fromString(text);
        } catch (IllegalArgumentException ignore) {

        }
        return uuid != null;
    }
}
