package br.com.fiap.api_petshop.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import br.com.fiap.api_petshop.dto.ProdutoRequest;
import br.com.fiap.api_petshop.dto.ProdutoResponse;
import br.com.fiap.api_petshop.exception.ResourceNotFoundException;
import br.com.fiap.api_petshop.service.ProdutoService;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProdutoService service;

    @Test
    void findAllReturnsList() throws Exception {
        when(service.findAll()).thenReturn(List.of(new ProdutoResponse(1L, "Banho", BigDecimal.valueOf(10.50))));

        mockMvc.perform(get("/api/v1/produtos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("Banho"));
    }

    @Test
    void createReturnsCreated() throws Exception {
        when(service.create(any(ProdutoRequest.class)))
                .thenReturn(new ProdutoResponse(5L, "Tosa", BigDecimal.valueOf(15.23)));

        mockMvc.perform(post("/api/v1/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"Tosa\",\"valor\":15.23}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(5))
                .andExpect(jsonPath("$.nome").value("Tosa"));
    }

    @Test
    void createWithBlankNomeReturnsBadRequest() throws Exception {
        mockMvc.perform(post("/api/v1/produtos")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"nome\":\"\",\"valor\":15.23}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void findByIdNotFoundReturns404() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Produto não encontrado: 99"));

        mockMvc.perform(get("/api/v1/produtos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deleteReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/v1/produtos/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteMissingReturns404() throws Exception {
        doThrow(new ResourceNotFoundException("Produto não encontrado: 99"))
                .when(service).deleteById(eq(99L));

        mockMvc.perform(delete("/api/v1/produtos/99"))
                .andExpect(status().isNotFound());
    }
}
