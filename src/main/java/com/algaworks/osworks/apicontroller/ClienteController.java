package com.algaworks.osworks.apicontroller;


import com.algaworks.osworks.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.List;


//@ResController é uma anotacão que permite scannear o projeto con controller
@RestController

//Clase responsável por receber as requisicões externas HTPP e responder
public class ClienteController {

    //@GetMappin("/clientes") localizacão URL da sua lista de objetos clientes
    //List apresenta uma lista da sua colecão de objetos
    //List<Cliente> =< <Cliente> é o nome da sua classe entity ou model.
    // cliente é o objeto.
    // Cliente é a classe.
    //EntytyManager é uma interfase do Jakarte Persistence que permite fazer operacões na tabela como criacão, consulta, etc.
    //@PersistenteContext: permite instanciar o EntityManager


    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
    return manager.createQuery("from Cliente", Cliente.class)
            .getResultList();


    }
}
