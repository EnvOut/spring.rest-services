package com.springframework.web.restservices.domain.configuration;

import com.springframework.source.fields.MetaField;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConfigModel {
    private final String name;
    private List<MetaField> fields;
}
