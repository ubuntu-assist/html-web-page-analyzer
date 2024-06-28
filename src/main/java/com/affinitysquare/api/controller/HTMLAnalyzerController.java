package com.affinitysquare.api.controller;

import com.affinitysquare.parser.*;
import com.affinitysquare.parser.data.LinkType;
import com.affinitysquare.api.model.Link;
import com.affinitysquare.api.model.Links;
import com.affinitysquare.api.model.MetaData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This is the main controller for handling HTML analysis requests.
 */
@RestController
@RequestMapping("/api/v1")
public class HTMLAnalyzerController {
    private static final Log log = LogFactory.getLog(HTMLAnalyzerController.class);

    /**
     * This method retrieves and processes metadata from a given URL.
     *
     * @param url The URL from which to retrieve the metadata. If not provided, it defaults to "http://".
     * @return A MetaData object containing the extracted metadata.
     */
    @GetMapping("metadata")
    public MetaData metadata(@RequestParam(value="url", defaultValue="http://") String url) {
        log.info("Retrieving metadata for url: " + url);
        HtmlParser parser = new MetaDataParser();
        MetaData metadata = new MetaData();
        RequestWrapper request = new RequestWrapper();
        request.setUrl(url);
        ResultsWrapper results = parser.parse(request);
        if(results.getMetadata() != null){
            metadata.setHtmlVersion(results.getMetadata().getHtmlVersion());
            metadata.setTitle(results.getMetadata().getTitle());
            Map<String, Long> header = results.getMetadata().getHeader();
            if(header != null){
                populateHeader(metadata, header);
            }
            metadata.setHasLogin(results.getMetadata().isLogin());
            Map<LinkType, Integer> links = results.getMetadata().getLinkCount();
            if(links != null){
                metadata.setInternalLinks(links.get(LinkType.INTERNAL) != null ? links.get(LinkType.INTERNAL) : 0);
                metadata.setExternalLinks(links.get(LinkType.EXTERNAL) != null ? links.get(LinkType.EXTERNAL) : 0);
            }
        }
        return metadata;
    }

    /**
     * This method populates the MetaData object with the count of each HTML header tag found in the parsed HTML.
     *
     * @param metaData The MetaData object to be populated.
     * @param header A Map containing the count of each HTML header tag. The keys are the tag names (e.g., "h1", "h2", etc.) and the values are the counts.
     */
    private void populateHeader(MetaData metaData, Map<String, Long> header){
        Long value;
        metaData.setH1Count(((value = header.get("h1")) != null) ? value.intValue() : 0);
        metaData.setH2Count(((value = header.get("h2")) != null) ? value.intValue() : 0);
        metaData.setH3Count(((value = header.get("h3")) != null) ? value.intValue() : 0);
        metaData.setH4Count(((value = header.get("h4")) != null) ? value.intValue() : 0);
        metaData.setH5Count(((value = header.get("h5")) != null) ? value.intValue() : 0);
        metaData.setH6Count(((value = header.get("h6")) != null) ? value.intValue() : 0);
    }

    /**
     * This method retrieves and processes links from a given URL.
     *
     * @param url The URL from which to retrieve the links. If not provided, it defaults to "http://".
     * @param pageSize The number of links to retrieve per page. If not provided, it defaults to 5.
     * @param pageNumber The page number of the links to retrieve. If not provided, it defaults to 1.
     * @return A Links object containing the extracted links and their reachability status.
     */
    @GetMapping("links")
    public Links<Link> links(@RequestParam(value="url", defaultValue="http://") String url,
                             @RequestParam(value="pageSize", defaultValue="5") int pageSize,
                             @RequestParam(value="pageNumber", defaultValue="1") int pageNumber) {
        log.info("Retrieving metadata for url: " + url);
        HtmlParser parser = new LinkParser();
        RequestWrapper request = new RequestWrapper();
        request.setUrl(url);
        if(pageSize <= 0){
            pageSize = 5;
        }
        if(pageNumber <= 0){
            pageNumber = 1;
        }
        request.setLimit(pageSize);
        request.setOffset((pageNumber - 1) * pageSize);
        ResultsWrapper results = parser.parse(request);
        List<Link> links = new ArrayList<>();
        //Check if each links is reachable or not
        for(int i = 0, l = results.getLinks().size(); i < l; i ++){
            links.add(isLinkReachable(results.getLinks().get(i), 1000));
        }
        Links<Link> linkResponse = new Links<>();
        linkResponse.setLinks(links);
        return linkResponse;
    }


    /**
     * This method checks if a given URL is reachable by sending a HEAD request.
     *
     * @param url The URL to check.
     * @param timeout The maximum time to wait for a response in milliseconds.
     * @return A Link object containing the URL, reachability status, and HTTP status code.
     */
    public static Link isLinkReachable(String url, int timeout) {
        Link link = new Link();
        link.setUrl(url);
        url = url.replaceFirst("^https", "http"); // Otherwise an exception may be thrown on invalid SSL certificates.
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(timeout);
            connection.setReadTimeout(timeout);
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            link.setReachable((200 <= responseCode && responseCode <= 399)); //verify the html response code and
            // record this as reachable or not based on the html response code.
            link.setStatus(String.valueOf(responseCode));
        } catch (IOException exception) {
            log.info("Error verifying link url: " + url);
            link.setReachable(false);
            link.setStatus(exception.getLocalizedMessage());
        } catch (Exception e){
            log.info("Error verifying link url: " + url);
            link.setReachable(false);
            link.setStatus("Error verifying the url: " + url);
        }
        return link;
    }

}
