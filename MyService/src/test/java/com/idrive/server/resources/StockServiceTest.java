package com.idrive.server.resources;

import com.google.common.util.concurrent.RateLimiter;
import com.idrive.filter.RateLimiterFilter;
import org.glassfish.jersey.servlet.WebConfig;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {StockService.class, RateLimiterFilter.class})
@WebAppConfiguration
public class StockServiceTest {

    MockMvc mockMvc;

    @Mock
    RateLimiterFilter rateLimiterFilter;

    @InjectMocks
    StockService stockService;

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(stockService)
                        .build();
    }

    @Test
    public void test() throws Exception{
        this.mockMvc.perform(get("/stock/price")
                ).andDo(print()).andExpect(status().isOk());


    }

}
