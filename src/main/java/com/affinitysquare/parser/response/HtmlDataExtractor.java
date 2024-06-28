package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;

public interface HtmlDataExtractor<T> {
    /**
     * Interface to retrieve data form a given Document
     * @param document Jsoup document object
     * @return Generic response object
     */
    T extract(Document document);
}
