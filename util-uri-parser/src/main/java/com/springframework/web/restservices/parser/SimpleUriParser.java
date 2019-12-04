package com.springframework.web.restservices.parser;

import com.springframework.web.restservices.domain.contract.parser.UriParser;
import com.springframework.web.restservices.domain.uri.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public class SimpleUriParser implements UriParser {
    private final Double version;
    private final Language language;
    private final Map<String, String> filters;
    private final LinkedList<Sort> sortList;
    private final List<EmbedObject> embedList;
    private final boolean pretty;
    private final Page page;
    private final MediaType mediaType;
    private final String search;
    private final List<InnerObject> innerList;

//    public static UriParser from(LinkedList<String> pathList)

    public static UriParser from(URI uri) {
        LinkedList<String> pathList = Stream.of(uri.getPath())
                .map(it -> it.split("/"))
                .map(Arrays::asList)
                .flatMap(List::stream)
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toCollection(LinkedList::new));
        if (pathList.isEmpty()) {
            throw new RuntimeException("empty path");
        }

        Map<String, String> parameters = Stream.of(uri.getQuery())
                .map(i -> i.split("&"))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .map(i -> i.split("="))
                .collect(Collectors.toMap(i -> i[0], y -> y.length > 1 ? y[1] : ""));

        Double version = Optional.of(pathList.getFirst())
                .filter(NumberUtils::isCreatable)
                .map(NumberUtils::createDouble)
                .orElse(null);

        Language lang = pathList.subList(0, 2).stream()
                .map(Language::from)
                .filter(Optional::isPresent)
                .findFirst()
                .flatMap(it -> it)
                .orElse(null);

        // /users/1/roles
        LinkedList<InnerObject> innerList = Optional.of((version != null ? 1 : 0) + (lang != null ? 1 : 0))
                .map(innerStartIndex -> pathList.subList(innerStartIndex, pathList.size()))
                .map(InnerObject::from)
                .filter(it -> !it.isEmpty())
                .orElse(null);

        // sort=-name,age,-id
        LinkedList<Sort> sortList = Stream.of(parameters)
                .map(i -> i.remove(URIParamConst.SORT))
                .filter(Objects::nonNull)
//                .map(i -> i.split("="))
//                .filter(i -> i.length > 1)
//                .map(i -> i[1])
                .map(i -> i.split(","))
                .filter(i -> i.length > 0)
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .filter(StringUtils::isNotEmpty)
                .map(i -> i.split("-"))
                .map(i -> i.length == 2 ? Sort.desc(i[1]) : Sort.asc(i[0]))
                .collect(Collectors.toCollection(LinkedList::new));

        String page_param = parameters.remove(URIParamConst.PAGE);
        String size_param = parameters.remove(URIParamConst.SIZE);
        Page page = Page.of(page_param, size_param);

        // embed=name,surname.type
        List<EmbedObject> embedList = Stream.of(parameters.remove(URIParamConst.EMBED))
                .filter(Objects::nonNull)
                .map(i -> i.split(","))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .map(EmbedObject::new)
                .collect(Collectors.toList());

        boolean pretty = Objects.equals(parameters.remove(URIParamConst.PRETTY), "true");

        MediaType mediaType = Optional.of(pathList)
                .map(LinkedList::getLast)
                .map(it -> it.split("\\."))
                .filter(it -> it.length == 2)
                .map(it -> it[1])
                .flatMap(MediaType::find)
                .orElse(null);

        String search = parameters.remove(URIParamConst.SEARCH);
        return new SimpleUriParser(version, lang, parameters, sortList,
                embedList, pretty, page, mediaType, search, innerList);
    }
}
