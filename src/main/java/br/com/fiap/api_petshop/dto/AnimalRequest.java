package br.com.fiap.api_petshop.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AnimalRequest(
        @NotBlank(message = "nome é obrigatório") @Size(max = 100, message = "nome deve ter no máximo 100 caracteres") String nome) {
}
