package com.algaworks.osworks.apicontroller;


import com.algaworks.osworks.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Simone Veronica");
        cliente1.setEmail("simoneperiodista3@hotmail.com");
        cliente1.setTelefone("34 9999-1111");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Lucas");
        cliente2.setEmail("lucaslipo@gmail.com");
        cliente2.setTelefone("11 8888-2222");

        return Arrays.asList(cliente1, cliente2);

    }
}
