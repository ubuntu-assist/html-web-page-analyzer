package com.affinitysquare.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LinksTest {

    private Links<String> stringLinks;
    private Links<Integer> integerLinks;

    @BeforeEach
    void setUp() {
        stringLinks = new Links<>();
        integerLinks = new Links<>();
    }

    @Test
    void testGetAndSetLinks_String() {
        List<String> expectedLinks = new ArrayList<>();
        expectedLinks.add("https://example.com");
        expectedLinks.add("https://test.com");

        stringLinks.setLinks(expectedLinks);
        List<String> actualLinks = stringLinks.getLinks();

        assertEquals(expectedLinks, actualLinks);
    }

    @Test
    void testGetAndSetLinks_Integer() {
        List<Integer> expectedLinks = new ArrayList<>();
        expectedLinks.add(1);
        expectedLinks.add(2);

        integerLinks.setLinks(expectedLinks);
        List<Integer> actualLinks = integerLinks.getLinks();

        assertEquals(expectedLinks, actualLinks);
    }

    @Test
    void testGetLinks_AfterSettingNull() {
        stringLinks.setLinks(null);
        assertNull(stringLinks.getLinks());
    }
}