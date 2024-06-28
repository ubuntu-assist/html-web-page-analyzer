package com.affinitysquare.parser.data;

import java.util.Map;

public class Metadata {
    private String htmlVersion;

    private String title;

    private Map<String, Long> header;

    private boolean login;

    private Map<LinkType, Integer> linkCount;

    public String getHtmlVersion() {
        return htmlVersion;
    }

    public void setHtmlVersion(String htmlVersion) {
        this.htmlVersion = htmlVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Long> getHeader() {
        return header;
    }

    public void setHeader(Map<String, Long> header) {
        this.header = header;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public Map<LinkType, Integer> getLinkCount() {
        return linkCount;
    }

    public void setLinkCount(Map<LinkType, Integer> linkCount) {
        this.linkCount = linkCount;
    }
}
