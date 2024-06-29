package com.affinitysquare.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class HTMLAnalyzerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldGetPageTitle() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Google"));
    }

    @Test
    void itShouldCheckIfPageContainsLoginForm() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://github.com/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hasLogin").value(true));
    }

    @Test
    void itShouldNoticeWhenPageDoesNotContainLoginForm() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hasLogin").value(false));
    }

    @Test
    void itShouldCheckIfPageVersionIsHtml5() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://github.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.htmlVersion").value("HTML 5.0"));
    }

    @Test
    void itShouldCheckIfPageVersionIsHtml4() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=http://www.htmlhelp.com/reference/html40/structure.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.htmlVersion").value("-//W3C//DTD HTML 4.01//EN"));
    }

    @Test
    void itShouldCountPageHeadings() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.h1Count").isNotEmpty())
                .andExpect(jsonPath("$.h2Count").isNotEmpty())
                .andExpect(jsonPath("$.h3Count").isNotEmpty())
                .andExpect(jsonPath("$.h4Count").isNotEmpty())
                .andExpect(jsonPath("$.h5Count").isNotEmpty())
                .andExpect(jsonPath("$.h6Count").isNotEmpty());
    }

    @Test
    void itShouldCountPageInternalAndExternalLinks() throws Exception {
        this.mockMvc.perform(get("/api/v1/metadata?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.internalLinks").isNotEmpty())
                .andExpect(jsonPath("$.externalLinks").isNotEmpty());
    }

    @Test
    void itShouldTestIfLinkAreReachable() throws Exception {
        this.mockMvc.perform(get("/api/v1/links?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.links[*].url").isNotEmpty())
                .andExpect(jsonPath("$.links[*].reachable").isNotEmpty())
                .andExpect(jsonPath("$.links[*].status").isNotEmpty());
    }

    @Test
    void itShouldCountPageLinks() throws Exception {
        this.mockMvc.perform(get("/api/v1/links?url=https://google.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.links.length()").value(5));
    }
}
