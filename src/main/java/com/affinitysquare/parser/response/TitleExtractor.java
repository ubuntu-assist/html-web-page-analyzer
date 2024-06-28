package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;

public class TitleExtractor implements HtmlDataExtractor<String> {
    /**
     * Method to extract the title
     * @param document Jsoup document object
     * @return HTML title information
     */
    @Override
    public String extract(Document document) {
        return document.title();
    }
}
