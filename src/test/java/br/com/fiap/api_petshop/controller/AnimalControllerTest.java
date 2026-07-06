package br.com.fiap.api_petshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.fiap.api_petshop.dto.AnimalRequest;
import br.com.fiap.api_petshop.dto.AnimalResponse;
import br.com.fiap.api_petshop.service.AnimalService;

@WebMvcTest(AnimalController.class)
class AnimalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AnimalService service;

    @Test
    void findAllReturnsList() throws Exception {
        when(service.findAll()).thenReturn(List.of(new AnimalResponse(1L, "Rex")));

        mockMvc.perform(get("/api/v1/animais"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Rex"));
    }

    @Test
    void createReturnsCreated() throws Exception {
        when(service.create(any(AnimalRequest.class))).thenReturn(new AnimalResponse(3L, "Rex"));

        mockMvc.perform(post("/api/v1/animais")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Rex\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3));
    }

    @Test
    void createWithBlankNomeReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/v1/animais")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"\"}"))
                .andExpect(status().isBadRequest());
    }
}
