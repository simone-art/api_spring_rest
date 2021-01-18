package com.algaworks.osworks.domain.repository;

import com.algaworks.osworks.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    List<Cliente> findByNomeContaining(String nome);
    //Não deve ser uma lista porque você está querendo comparar um só email, que deve ser único
    Cliente findByEmail(String email);

}
