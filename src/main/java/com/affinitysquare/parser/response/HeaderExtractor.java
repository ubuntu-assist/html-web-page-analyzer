package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Map;
import java.util.stream.Collectors;

public class HeaderExtractor implements HtmlDataExtractor<Map<String, Long>> {
    /**
     * Implements the interface HtmlDataExtractor to extract header information
     * @param document Jsoup document object
     * @return Map of header type and total count of each type of header
     */
    @Override
    public Map<String, Long> extract(Document document) {
        Elements hTags = document.select("h1, h2, h3, h4, h5, h6");
        return hTags.stream().collect(Collectors.groupingBy(Element::tagName, Collectors
                .counting()));

    }
}
