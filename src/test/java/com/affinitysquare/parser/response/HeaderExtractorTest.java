package com.affinitysquare.parser.response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HeaderExtractorTest {

    private HeaderExtractor headerExtractor;

    @BeforeEach
    void setUp() {
        headerExtractor = new HeaderExtractor();
    }

    @Test
    void testSingleHeaderType() {
        String html = "<html><head><title>Test Page</title></head><body><h1>Header 1</h1></body></html>";
        Document document = Jsoup.parse(html);
        Map<String, Long> headerCounts = headerExtractor.extract(document);
        assertEquals(1, headerCounts.size());
        assertEquals(1L, headerCounts.get("h1"));
    }

    @Test
    void testMultipleHeaderTypes() {
        String html = "<html><head><title>Test Page</title></head><body><h1>Header 1</h1><h2>Header 2</h2><h3>Header 3</h3></body></html>";
        Document document = Jsoup.parse(html);
        Map<String, Long> headerCounts = headerExtractor.extract(document);
        assertEquals(3, headerCounts.size());
        assertEquals(1L, headerCounts.get("h1"));
        assertEquals(1L, headerCounts.get("h2"));
        assertEquals(1L, headerCounts.get("h3"));
    }

    @Test
    void testNoHeaders() {
        String html = "<html><head><title>Test Page</title></head><body><p>No headers here</p></body></html>";
        Document document = Jsoup.parse(html);
        Map<String, Long> headerCounts = headerExtractor.extract(document);
        assertEquals(0, headerCounts.size());
    }

    @Test
    void testEmptyHtml() {
        String html = "<html><head><title>Test Page</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        Map<String, Long> headerCounts = headerExtractor.extract(document);
        assertEquals(0, headerCounts.size());
    }
}