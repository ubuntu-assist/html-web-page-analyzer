package com.affinitysquare.api.model;

/**
 * This class represents the metadata of a webpage.
 * It contains various attributes such as title, HTML version, login status, heading counts, and link counts.
 */
public class MetaData {

    private String title;

    private String htmlVersion;

    private boolean hasLogin;

    private int h1Count;
    private int h2Count;
    private int h3Count;
    private int h4Count;
    private int h5Count;
    private int h6Count;

    private int internalLinks;
    private int externalLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlVersion() {
        return htmlVersion;
    }

    public void setHtmlVersion(String htmlVersion) {
        this.htmlVersion = htmlVersion;
    }

    public int getH1Count() {
        return h1Count;
    }

    public void setH1Count(int h1Count) {
        this.h1Count = h1Count;
    }

    public int getH2Count() {
        return h2Count;
    }

    public void setH2Count(int h2Count) {
        this.h2Count = h2Count;
    }

    public int getH3Count() {
        return h3Count;
    }

    public void setH3Count(int h3Count) {
        this.h3Count = h3Count;
    }

    public int getH4Count() {
        return h4Count;
    }

    public void setH4Count(int h4Count) {
        this.h4Count = h4Count;
    }

    public int getH5Count() {
        return h5Count;
    }

    public void setH5Count(int h5Count) {
        this.h5Count = h5Count;
    }

    public int getH6Count() {
        return h6Count;
    }

    public void setH6Count(int h6Count) {
        this.h6Count = h6Count;
    }

    public boolean isHasLogin() {
        return hasLogin;
    }

    public void setHasLogin(boolean hasLogin) {
        this.hasLogin = hasLogin;
    }

    public int getInternalLinks() {
        return internalLinks;
    }

    public void setInternalLinks(int internalLinks) {
        this.internalLinks = internalLinks;
    }

    public int getExternalLinks() {
        return externalLinks;
    }

    public void setExternalLinks(int externalLinks) {
        this.externalLinks = externalLinks;
    }
}
