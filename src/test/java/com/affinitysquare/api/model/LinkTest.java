package com.affinitysquare.api.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkTest {

    private Link link;

    @BeforeEach
    void setUp() {
        link = new Link();
    }

    @Test
    void testGetAndSetUrl() {
        String url = "https://example.com";
        link.setUrl(url);
        assertEquals(url, link.getUrl());
    }

    @Test
    void testGetAndSetReachable() {
        link.setReachable(true);
        assertTrue(link.isReachable());

        link.setReachable(false);
        assertFalse(link.isReachable());
    }

    @Test
    void testGetAndSetStatus() {
        String status = "200 OK";
        link.setStatus(status);
        assertEquals(status, link.getStatus());
    }

    @Test
    void testDefaultValues() {
        assertNull(link.getUrl());
        assertFalse(link.isReachable());
        assertNull(link.getStatus());
    }
}