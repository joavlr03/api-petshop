package br.com.fiap.api_petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.api_petshop.model.Produto;


@Repository
public interface ServicoRepository extends JpaRepository<Produto, Long>{

}