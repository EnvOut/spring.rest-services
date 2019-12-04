package com.springframework.source.constraints;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConstraintException extends RuntimeException {
    private final String message;
}
