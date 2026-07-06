package br.com.fiap.api_petshop.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record ProdutoRequest(
        @NotBlank(message = "nome é obrigatório") String nome,
        @NotNull(message = "valor é obrigatório") @PositiveOrZero(message = "valor não pode ser negativo") BigDecimal valor) {
}
