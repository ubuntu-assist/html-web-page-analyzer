package com.affinitysquare.parser.response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginInfoExtractorTest {

    @Test
    void testLoginFormWithUsernameAndPassword() {
        String html = "<form><input type='text' name='username'><input type='password' name='password'></form>";
        Document document = Jsoup.parse(html);
        LoginInfoExtractor extractor = new LoginInfoExtractor();
        assertTrue(extractor.extract(document));
    }

    @Test
    void testLoginFormWithEmailAndPassword() {
        String html = "<form><input type='email' name='email'><input type='password' name='password'></form>";
        Document document = Jsoup.parse(html);
        LoginInfoExtractor extractor = new LoginInfoExtractor();
        assertTrue(extractor.extract(document));
    }

    @Test
    void testLoginFormWithoutUsernameOrPassword() {
        String html = "<form><input type='text' name='name'><input type='text' name='email'></form>";
        Document document = Jsoup.parse(html);
        LoginInfoExtractor extractor = new LoginInfoExtractor();
        assertFalse(extractor.extract(document));
    }

    @Test
    void testLoginFormWithExtraInputFields() {
        String html = "<form><input type='text' name='username'><input type='password' name='password'><input type='hidden' name='csrf_token'></form>";
        Document document = Jsoup.parse(html);
        LoginInfoExtractor extractor = new LoginInfoExtractor();
        assertTrue(extractor.extract(document));
    }

    @Test
    void testEmptyForm() {
        String html = "<form></form>";
        Document document = Jsoup.parse(html);
        LoginInfoExtractor extractor = new LoginInfoExtractor();
        assertFalse(extractor.extract(document));
    }
}