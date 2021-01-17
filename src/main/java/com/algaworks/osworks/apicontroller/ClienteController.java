package com.algaworks.osworks.apicontroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//@ResController é uma anotacão que permite scannear o projeto con controller
@RestController

//Clase responsável por receber as requisicões externas HTPP e responder
public class ClienteController {

    @GetMapping("/clientes")
    public String listar(){
        return "Teste";

    }
}
