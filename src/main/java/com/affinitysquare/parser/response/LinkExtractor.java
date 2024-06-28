package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;

import java.util.List;

public class LinkExtractor implements HtmlDataExtractor<List<String>> {
    /**
     * Extract the links from the given Jsoup Document object
     * @param document Jsoup document object
     * @return List of links
     */
    @Override
    public List<String> extract(Document document) {
        return LinkExtractorHelper.extract(document);
    }
}
