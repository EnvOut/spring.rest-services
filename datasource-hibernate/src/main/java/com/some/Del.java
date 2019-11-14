package com.some;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Size;

@SpringBootApplication
public class Del {

    @Size
    @NonNull
    private String some;

    public static void main(String[] args) {
        SpringApplication.run(Del.class);
    }
}
