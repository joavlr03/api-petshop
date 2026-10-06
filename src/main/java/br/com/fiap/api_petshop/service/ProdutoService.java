package br.com.fiap.api_petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.api_petshop.dto.ProdutoRequest;
import br.com.fiap.api_petshop.dto.ProdutoResponse;
import br.com.fiap.api_petshop.exception.ResourceNotFoundException;
import br.com.fiap.api_petshop.model.Produto;
import br.com.fiap.api_petshop.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<ProdutoResponse> findAll() {
        return repository.findAll().stream().map(ProdutoResponse::from).toList();
    }

    public ProdutoResponse findById(Long id) {
        return repository.findById(id)
                .map(ProdutoResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + id));
    }

    public ProdutoResponse create(ProdutoRequest request) {
        Produto produto = new Produto();
        produto.setNome(request.nome());
        produto.setValor(request.valor());
        return ProdutoResponse.from(repository.save(produto));
    }

    public ProdutoResponse update(Long id, ProdutoRequest request) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado: " + id));
        produto.setNome(request.nome());
        produto.setValor(request.valor());
        return ProdutoResponse.from(repository.save(produto));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Produto não encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
