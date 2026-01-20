package com.checkpoint.controller;

import com.checkpoint.service.ArticleService;
import com.checkpoint.service.IArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ArticleController.class, ArticleService.class})
@WebAppConfiguration
public class ArticleControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    ArticleController articleController;

    @Mock
    IArticleService articleService;


    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(articleController)
                .build();
    }

    @Test
    public void test() throws Exception{
        this.mockMvc.perform(get("/user/articles")
        ).andDo(print()).andExpect(status().isOk());


    }

}