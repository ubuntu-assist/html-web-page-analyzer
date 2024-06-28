package com.affinitysquare.parser;

public interface HtmlParser {
    //JSoup timeout configuration. Set to maximum of 10s.
    int TIME_OUT = 10000;

    /**
     * Implement this interface to parse different parts of html page.
     * @param request RequestWrapper containing request attributes
     * @return ResultsWrapper object containing response data.
     */
    ResultsWrapper parse(RequestWrapper request);
}
