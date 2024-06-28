package com.affinitysquare.api.model;

/**
 * This class represents a link with its URL, reachability status, and status code.
 */
public class Link {
    private String url;
    private boolean reachable;
    private String status;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isReachable() {
        return reachable;
    }

    public void setReachable(boolean reachable) {
        this.reachable = reachable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
