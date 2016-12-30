package com.openpolicy;

import com.openpolicy.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleService service;

    @Test
    public void homePage() throws Exception {
        // N.B. jsoup can be useful for asserting HTML content
        mockMvc.perform(get("/"))
                .andExpect(content().string(containsString("Hello, World!")));
    }

    @Test
    public void article() throws Exception {
        mockMvc.perform(get("/article"))
                .andExpect(content().string(containsString("Hello, First!")));
    }

    @Test
    public void homeWithData() throws Exception {
        mockMvc.perform(get("/").param("name", "Greg"))
                .andExpect(content().string(containsString("Hello, Greg!")));
    }
}
