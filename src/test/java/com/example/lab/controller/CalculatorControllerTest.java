package com.example.lab.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.lab.service.CalculatorService;

@WebMvcTest(CalculatorController.class)
@Import(CalculatorService.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void addNegativeAndPositive_returnsZero() throws Exception {
        mockMvc.perform(get("/ms1/add")
                    .param("a", "-5")
                    .param("b", "5"))
               .andExpect(status().isOk())
               .andExpect(content().string("MS 1.1 - Additon = 0"));
    }

    @Test
    void addTwoNegatives() throws Exception {
        mockMvc.perform(get("/ms1/add").param("a", "-3").param("b", "-7"))
               .andExpect(status().isOk())
               .andExpect(content().string("MS 1.1 - Additon = -10"));
    }

    @Test
    void addZeros() throws Exception {
        mockMvc.perform(get("/ms1/add").param("a", "0").param("b", "0"))
               .andExpect(status().isOk())
               .andExpect(content().string("MS 1.1 - Additon = 0"));
    }

    @Test
    void contentTypeIsPlainText() throws Exception {
        mockMvc.perform(get("/ms1/add").param("a", "1").param("b", "2"))
               .andExpect(status().isOk())
               .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }

    @Test
    void missingParameter_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/ms1/add").param("a", "5"))
               .andExpect(status().isBadRequest());
    }

    @Test
    void nonNumericParameter_returnsBadRequest() throws Exception {
        mockMvc.perform(get("/ms1/add").param("a", "abc").param("b", "5"))
               .andExpect(status().isBadRequest());
    }
}