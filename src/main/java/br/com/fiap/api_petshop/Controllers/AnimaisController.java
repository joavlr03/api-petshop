package br.com.fiap.api_petshop.Controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class AnimaisController {
     @GetMapping("/RacasAnimais")
    public String servicos(){
        return "Animais que atendemos: Cães, Gatos, Aves";
    }

   
}
