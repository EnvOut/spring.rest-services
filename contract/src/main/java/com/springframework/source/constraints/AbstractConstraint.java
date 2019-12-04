package com.springframework.source.constraints;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractConstraint implements Constraint {
    private String message;
}
