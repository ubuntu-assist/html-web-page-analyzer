package com.affinitysquare.parser.response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TitleExtractorTest {

    private TitleExtractor titleExtractor;

    @BeforeEach
    void setUp() {
        titleExtractor = new TitleExtractor();
    }

    @Test
    void testExtract_ValidHtmlDocumentWithTitleTag_ReturnsCorrectTitle() {
        String html = "<html><head><title>Test Title</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        String expectedTitle = "Test Title";

        String actualTitle = titleExtractor.extract(document);

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testExtract_ValidHtmlDocumentWithTitleTagInDifferentLanguage_ReturnsCorrectTitle() {
        String html = "<html><head><title lang='es'>Título de prueba</title></head><body></body></html>";
        Document document = Jsoup.parse(html);
        String expectedTitle = "Título de prueba";

        String actualTitle = titleExtractor.extract(document);

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testExtract_ValidHtmlDocumentWithoutTitleTag_ReturnsEmptyString() {
        String html = "<html><head></head><body></body></html>";
        Document document = Jsoup.parse(html);
        String expectedTitle = "";

        String actualTitle = titleExtractor.extract(document);

        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testExtract_EmptyHtmlDocument_ReturnsEmptyString() {
        String html = "";
        Document document = Jsoup.parse(html);
        String expectedTitle = "";

        String actualTitle = titleExtractor.extract(document);

        assertEquals(expectedTitle, actualTitle);
    }
}