package com.affinitysquare.parser.response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VersionExtractorTest {

    @Test
    void testHtml5Document() {
        String html = "<!DOCTYPE html><html><head><title>Test</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        VersionExtractor extractor = new VersionExtractor();
        assertEquals("HTML 5.0", extractor.extract(document));
    }

    @Test
    void testHtml4StrictDocument() {
        String html = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"><html><head><title>Test</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        VersionExtractor extractor = new VersionExtractor();
        assertEquals("-//W3C//DTD HTML 4.01//EN", extractor.extract(document));
    }

    @Test
    void testXhtmlDocument() {
        String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html><head><title>Test</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        VersionExtractor extractor = new VersionExtractor();
        assertEquals("-//W3C//DTD XHTML 1.0 Transitional//EN", extractor.extract(document));
    }

    @Test
    void testHtml5DocumentWithComments() {
        String html = "<!DOCTYPE html><!-- Comment --><html><head><title>Test</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        VersionExtractor extractor = new VersionExtractor();
        assertEquals("HTML 5.0", extractor.extract(document));
    }

    @Test
    void testEmptyDocument() {
        String html = "";
        Document document = Jsoup.parse(html);
        VersionExtractor extractor = new VersionExtractor();
        assertEquals("HTML 5.0", extractor.extract(document));
    }
}