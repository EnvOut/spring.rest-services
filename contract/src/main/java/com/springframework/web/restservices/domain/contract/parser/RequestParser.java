package com.springframework.web.restservices.domain.contract.parser;

public interface RequestParser {
    /**
     * Method from header (X-HTTP-Method-Override) or method from request
     * @return
     */
    String getMethod();
}
