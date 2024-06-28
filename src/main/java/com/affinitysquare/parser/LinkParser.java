package com.affinitysquare.parser;

import com.affinitysquare.parser.response.HtmlDataExtractor;
import com.affinitysquare.parser.response.LinkExtractor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LinkParser implements HtmlParser {
    private final Log log = LogFactory.getLog(LinkParser.class);

    /**
     * This method parses the HTML content of a given URL and extracts all the links.
     * It sorts the links in ascending order and returns a subset of links based on the provided offset and limit.
     *
     * @param request The request wrapper containing the URL, offset, and limit.
     * @return A ResultsWrapper object containing the extracted links.
     */
    @Override
    public ResultsWrapper parse(RequestWrapper request) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            URI uri = URI.create(request.getUrl());
            Document doc = Jsoup.parse(uri.toURL(), TIME_OUT);
            //Extract links
            HtmlDataExtractor<List<String>> extractor = new LinkExtractor();
            List<String> links = extractor.extract(doc);

            //Sort links
            links.sort(Comparator.comparing(String::toString));
            int offset = request.getOffset();
            int size = request.getLimit();

            //Retrieve a subset of links
            if(offset < links.size()){ //offset and limit should always be smaller than the size of list
                int limit = offset + size;
                if(limit > links.size()){
                    limit = links.size();
                }
                links = links.subList(offset, limit);
            }else{
                links = new ArrayList<>(); //return a empty list
            }
            resultsWrapper.setLinks(links);
        } catch (IOException e) {
            log.error("Failed to get metadata for the url: " + request.getUrl(), e);
        }
        return resultsWrapper;
    }
}
