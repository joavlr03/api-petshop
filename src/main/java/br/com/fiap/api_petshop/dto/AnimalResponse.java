package br.com.fiap.api_petshop.dto;

import br.com.fiap.api_petshop.model.Animal;

public record AnimalResponse(Long id, String nome) {

    public static AnimalResponse from(Animal animal) {
        return new AnimalResponse(animal.getId(), animal.getNome());
    }
}
