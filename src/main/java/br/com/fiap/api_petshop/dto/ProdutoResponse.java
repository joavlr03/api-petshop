package br.com.fiap.api_petshop.dto;

import java.math.BigDecimal;

import br.com.fiap.api_petshop.model.Produto;

public record ProdutoResponse(Long id, String nome, BigDecimal valor) {

    public static ProdutoResponse from(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getValor());
    }
}
