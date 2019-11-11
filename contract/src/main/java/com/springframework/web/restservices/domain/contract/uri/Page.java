package com.springframework.web.restservices.domain.contract.uri;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Page {
    private final Integer page;
    private final Integer size;

    public static Page of(Integer page, Integer size) {
        Page result = null;

        if (size != null && page == null) {
            page = 0;
        }


        if (ObjectUtils.allNotNull(size, page)) {
            result = new Page(page, size);
        }
        return result;
    }


    public static Page of(String pageParam, String sizeParam) {
        Integer pageInt = Optional.ofNullable(pageParam)
                .filter(NumberUtils::isDigits)
                .map(NumberUtils::createInteger)
                .orElse(null);
        Integer sizeInt = Optional.ofNullable(sizeParam)
                .filter(NumberUtils::isDigits)
                .map(NumberUtils::createInteger)
                .orElse(null);
        return new Page(pageInt, sizeInt);
    }
}
