package com.openpolicy;

import com.openpolicy.service.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ArticleService service;

    @Test
    public void homePage() throws Exception {
        // N.B. jsoup can be useful for asserting HTML content
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void article() throws Exception {
        mockMvc.perform(get("/article"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, "+service.getByID(0) +"!")));
    }

    @Test
    public void homeWithData() throws Exception {
        mockMvc.perform(get("/").param("name", "Greg"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, Greg!")));
    }
}
