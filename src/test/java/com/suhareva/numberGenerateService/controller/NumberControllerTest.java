package com.suhareva.numberGenerateService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suhareva.numberGenerateService.entity.Number;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class NumberControllerTest extends IntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void generateNumber_returnNumber() throws Exception {
        Number number = new Number();
        MvcResult mvcResult = mockMvc.perform(post("/numbers/generateNumber")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(number)))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andDo(print())
                .andReturn();
        Number actualNumber = objectMapper.readValue(
                mvcResult.getResponse().getContentAsString(),
                Number.class);
        assertNotNull(actualNumber);
        assertEquals(13, actualNumber.getNumber().length());
    }
}
