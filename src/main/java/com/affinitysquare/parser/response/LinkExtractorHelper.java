package com.affinitysquare.parser.response;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class LinkExtractorHelper {

    // Private constructor to prevent instantiation
    private LinkExtractorHelper() {
        // Private constructor to hide the implicit public one
        throw new AssertionError("This class should not be instantiated.");
    }

    /**
     * Static method to extract the links from a given Jsoup document.
     * @param document Jsoup document object
     * @return List of links
     */
    public static List<String> extract(Document document) {
        Elements links = document.select("a[href]");
        Elements media = document.select("[src]");
        Elements imports = document.select("link[href]");

        List<String> allLinks = new ArrayList<>();
        populateLinks(allLinks, media, "abs:src");
        populateLinks(allLinks, imports, "abs:href");
        populateLinks(allLinks, links, "abs:href");
        return allLinks;
    }

    private static void populateLinks(List<String> links, Elements elements, String attr){
        for (Element link : elements) {
            String linkUrl = link.attr(attr);
            if(!linkUrl.isEmpty()){
                links.add(linkUrl);
            }
        }
    }
}
