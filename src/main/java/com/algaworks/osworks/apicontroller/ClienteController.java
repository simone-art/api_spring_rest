package com.algaworks.osworks.apicontroller;


import com.algaworks.osworks.domain.model.Cliente;
import com.algaworks.osworks.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


//@ResController é uma anotacão que permite scannear o projeto con controller
@RestController
//@RequestMapping é uma anotação que responde a tudo que estiver no /clientes
// é aí no GetMapping não precisa colocar o path.
@RequestMapping("/clientes")

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

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
//        return clienteRepository.findByNome("Simone Santos");
//        return clienteRepository.findByNomeContaining("a");
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isPresent()) {
            //ResponseEntity retorna a resposta
            //O cliente é o optional o get e pra você buscar o que está dentro do optional
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping
    //@ReponseStatus(HttpStatus.CREATED) indica que o recurso está sendo criado
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        //Se você não colocar o setId, o código vai entender que você está criando
        // um novo cliente, e na verdade você está atualizando.
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")

    public ResponseEntity<Void> deletar(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        //NoContent é o status 204 e não retorna nada no corpo da requisição
        return ResponseEntity.noContent().build();
    }

}