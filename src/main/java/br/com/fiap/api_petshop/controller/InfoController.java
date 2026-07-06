package br.com.fiap.api_petshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/${api.version}/info")
public class InfoController {

    @GetMapping("/racas-animais")
    public List<String> racasAnimais() {
        return List.of("Cães", "Gatos", "Animais Selvagens", "Roedores");
    }

    @GetMapping("/servicos-disponiveis")
    public List<String> servicosDisponiveis() {
        return List.of("banho", "tosa", "vacinas");
    }
}
