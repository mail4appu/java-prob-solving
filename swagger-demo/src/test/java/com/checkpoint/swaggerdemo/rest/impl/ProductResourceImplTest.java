package com.checkpoint.swaggerdemo.rest.impl;

import com.checkpoint.swaggerdemo.dao.ProductRepository;
import com.checkpoint.swaggerdemo.model.Product;
import com.checkpoint.swaggerdemo.rest.impl.ProductResourceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.any;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductResourceImplTest {

    MockMvc mockMvc;

    @Mock
    ProductRepository productRepository;

    @Mock
    Page<Product> page;

    @Mock
    Pageable pageable;
    @Mock
    Stream<Product> productStream;

    @InjectMocks
    ProductResourceImpl productResource= new ProductResourceImpl();

    private String productList="{\"id\":\"5f1009b8c2361dca5d04d6c9\",\"name\":\"HP pavillion\",\"description\":\"string\",\"price\":\"4000$\",\"type\":\"high-end\",\"os\":\"ubuntu\"}";

    @Before
    public void setUp() throws JsonProcessingException {
        this.mockMvc = MockMvcBuilders.standaloneSetup(productResource)
                .build();
        final Product product = new ObjectMapper().readValue(productList, Product.class);
        final List<Product> products = Stream.of(product).collect(Collectors.toList());
        Mockito.when(productRepository.findAll(pageable)).thenReturn(page);
        Mockito.when(page.get()).thenReturn(productStream);
        Mockito.when(productStream.collect(Collectors.toList())).thenReturn(products);
    }

    @Test
    public void getAllProducts() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/products").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
    }

    @Test
    public void addProduct() {
    }

    @Test
    public void addProductV0() {
    }

    @Test
    public void getSingleProduct() {
    }

    @Test
    public void getSingleProductWithDeferredResult() {
    }

    @Test
    public void updateProduct() {
    }

    @Test
    public void deleteProduct() {
    }
}