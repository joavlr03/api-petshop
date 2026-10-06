package br.com.fiap.api_petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.api_petshop.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
