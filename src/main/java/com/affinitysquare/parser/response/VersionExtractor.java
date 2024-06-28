package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;

import java.util.List;

public class VersionExtractor implements HtmlDataExtractor<String> {
    /**
     * Method to extract the version information from a document. Checks for the DocumentType to find out the version
     * of a given html document
     * @param document Jsoup document object
     * @return HTML version
     */
    @Override
    public String extract(Document document) {
        List<String> list = document.childNodes().stream()
                .filter(DocumentType.class::isInstance)
                .map(x -> x.attr("publicid"))
                .toList();
        return (list.isEmpty() || list.get(0).isEmpty()) ? "HTML 5.0" : list.get(0);
    }
}
