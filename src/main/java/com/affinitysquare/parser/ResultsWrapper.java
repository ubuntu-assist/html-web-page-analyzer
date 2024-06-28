package com.affinitysquare.parser;

import com.affinitysquare.parser.data.Metadata;

import java.util.List;

/**
 * This class is a wrapper for the results of a parsing operation.
 * It contains two main components: metadata and links.
 */
public class ResultsWrapper {
    private Metadata metadata;
    private List<String> links;
    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }
}
