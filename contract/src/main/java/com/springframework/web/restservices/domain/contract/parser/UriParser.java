package com.springframework.web.restservices.domain.contract.parser;

import com.springframework.web.restservices.domain.uri.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface UriParser {


    Double getVersion();
    List<InnerObject> getInnerList();

    Language getLanguage();

    Map<String, String> getFilters();

    LinkedList<Sort> getSortList();

    String getSearch() ;

    List<EmbedObject> getEmbedList();

    boolean isPretty();

    Page getPage();

    MediaType getMediaType();
}
