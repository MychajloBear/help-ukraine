//package com.github.devbk84.backend.controller;
package de.ukrainewin.helpukraine.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.ukrainewin.helpukraine.model.Food;
import de.ukrainewin.helpukraine.repo.FoodRepo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource("/multipledb/multidb.properties")

class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FoodRepo repo;

    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    @AfterEach
    public void setUp() {
    	repo.deleteAll();
    	}

    
    @Test
    void getAllOrders_whenNoFoodInDB_thenReturnEmptyList() throws Exception {
        mockMvc.perform(get("/api/food"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));

    }

    @Test
    void testGetById() throws Exception {
        repo.save(new Food(
                "111",
                "Food1"
        ));

        mockMvc.perform(get("/api/food/111"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                        "id": "111",
                        "name": "Food1"
                        }
                        """));

    }
/*
    @Test
    void saveOrder() throws Exception {
        String content = mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                        {
                                        "payment": "PayPal",
                                        "products": [{
                                        "id": "8",
                                        "name": "Milk",
                                        "shortname": "milch",
                                        "description": "Test",
                                        "orderFavorites": "orderFav",
                                        "price": "1.5"
                                        }       ],
                                        "ordertBy": "Nick"
                                        }
                                        """

                        ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Order actualOrder = objectMapper.readValue(content, Order.class);
        Order expected = new Order(actualOrder.id(),
                "PayPal",
                List.of(new Product("8",
                        "Milk",
                        "Test",
                        "orderFav",
                        new BigDecimal("1.5"),
                        "milch")
                ),
                "Nick");

        assertEquals(expected, actualOrder);

    }

    @Test
    void addProductToAnOrder() throws Exception {
        Order order = new Order(
                "455454",
                "PayPal",
                new ArrayList<>(),
                "Nick"
        );
        repo.save(order);
        String content = mockMvc.perform(put("/api/orders/" + order.id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(
                                """
                                                                                  
                                        {
                                        "id": "8",
                                        "name": "Milk",
                                        "description": "Test",
                                        "orderFavorites": "orderFav",
                                        "price": "1.5",
                                        "shortname": "milch"
                                        }                                          
                                        """
                        ))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        Order actualOrder = objectMapper.readValue(content, Order.class);
        Order expected = new Order("455454",
                "PayPal",
                List.of(new Product(actualOrder.products().get(0).id(),
                        "Milk",
                        "Test",
                        "orderFav",
                        new BigDecimal("1.5"),
                        "milch")

                ), "Nick");


        assertEquals(expected, actualOrder);

    }*/
}