package br.com.fiap.api_petshop.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class ServicosController {

     @GetMapping("/serviços")
    public String servicos(){
        return "Lista de serviços disponíveis:";
    }

    @GetMapping("servicos/disponiveis")
    public String disponiveis(){
        return "banho, tosa, banho e tosa";
    }
    
}
