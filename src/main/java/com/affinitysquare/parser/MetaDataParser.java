package com.affinitysquare.parser;

import com.affinitysquare.parser.data.LinkType;
import com.affinitysquare.parser.data.Metadata;
import com.affinitysquare.parser.response.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class MetaDataParser implements HtmlParser {
    private final Log log = LogFactory.getLog(MetaDataParser.class);


    @Override
    @SuppressWarnings("unchecked")
    public ResultsWrapper parse(RequestWrapper request) {
        ResultsWrapper resultsWrapper = new ResultsWrapper();
        try {
            URI uri = URI.create(request.getUrl());
            Document doc = Jsoup.parse(uri.toURL(), TIME_OUT);
            Metadata metadata = new Metadata();
            HtmlDataExtractor<?> extractor;

            extractor = new VersionExtractor();
            metadata.setHtmlVersion((String)extractor.extract(doc));

            extractor = new TitleExtractor();
            metadata.setTitle((String)extractor.extract(doc));

            extractor = new HeaderExtractor();
            metadata.setHeader((Map<String, Long>)extractor.extract(doc));

            extractor = new LoginInfoExtractor();
            metadata.setLogin((Boolean)extractor.extract(doc));

            extractor = new LinkCountExtractor();
            metadata.setLinkCount((Map<LinkType, Integer>)extractor.extract(doc));

            resultsWrapper.setMetadata(metadata);
        } catch (IOException e) {
            log.error("Failed to get metadata for the url: " + request.getUrl(), e);
        }
        return resultsWrapper;
    }
}
