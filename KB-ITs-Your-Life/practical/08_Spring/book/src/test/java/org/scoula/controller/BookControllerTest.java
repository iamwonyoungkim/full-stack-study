package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.RootConfig;
import org.scoula.config.ServletConfig;
import org.scoula.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        RootConfig.class,
        ServletConfig.class,
})
@Log4j2
class BookControllerTest {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    void getAllBooks() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/books/"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }

    @Test
    void getBookWithDetail() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/books/1/detail"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }

    @Test
    void getBookReviews() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/books/1/reviews"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }

    @Test
    void getBookWithDetailAndReviews() throws Exception {
        ModelMap model = mockMvc.perform(MockMvcRequestBuilders.get("/books/1"))
                .andReturn()
                .getModelAndView()
                .getModelMap();
        log.info(model);
    }
}