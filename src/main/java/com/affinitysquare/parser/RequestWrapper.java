package com.affinitysquare.parser;

/**
 * This class is a wrapper for request parameters.
 * It holds the URL, limit, and offset for pagination.
 */
public class RequestWrapper {

    private String url;
    private int limit;
    private int offset;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
