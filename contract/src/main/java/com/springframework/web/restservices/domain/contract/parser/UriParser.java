package com.springframework.web.restservices.domain.contract.parser;

import com.springframework.web.restservices.domain.contract.uri.EmbedObject;
import com.springframework.web.restservices.domain.contract.uri.MediaType;
import com.springframework.web.restservices.domain.contract.uri.Page;
import com.springframework.web.restservices.domain.contract.uri.SortOrder;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface UriParser {


    Double getVersion();

    Map<String, String> getFilters();

    LinkedList<SortOrder> getSortList();

    default String getSearch() {
        throw new RuntimeException();
    }

    List<EmbedObject> getEmbedList();

    boolean isPretty();

    Page getPage();

    MediaType getMediaType();
}
