package br.com.fiap.api_petshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.api_petshop.dto.AnimalRequest;
import br.com.fiap.api_petshop.dto.AnimalResponse;
import br.com.fiap.api_petshop.exception.ResourceNotFoundException;
import br.com.fiap.api_petshop.model.Animal;
import br.com.fiap.api_petshop.repository.AnimalRepository;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<AnimalResponse> findAll() {
        return repository.findAll().stream().map(AnimalResponse::from).toList();
    }

    public AnimalResponse findById(Long id) {
        return repository.findById(id)
                .map(AnimalResponse::from)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado: " + id));
    }

    public AnimalResponse create(AnimalRequest request) {
        Animal animal = new Animal();
        animal.setNome(request.nome());
        return AnimalResponse.from(repository.save(animal));
    }

    public AnimalResponse update(Long id, AnimalRequest request) {
        Animal animal = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal não encontrado: " + id));
        animal.setNome(request.nome());
        return AnimalResponse.from(repository.save(animal));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Animal não encontrado: " + id);
        }
        repository.deleteById(id);
    }
}
