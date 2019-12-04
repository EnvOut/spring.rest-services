package com.springframework.web.restservices.domain.configuration.response;

import com.springframework.web.restservices.domain.http.HttpHeader;
import lombok.Data;

import java.util.List;

@Data
public class ResponseHeader {
    private List<HttpHeader> add;
}
