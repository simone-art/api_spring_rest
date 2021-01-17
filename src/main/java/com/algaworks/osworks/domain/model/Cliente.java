package com.algaworks.osworks.domain.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

//Pra criar a tabela no momento de fazer o run da aplicacão é necessario ter esta anotacão @Entity
//Do contrário a tabela não será criada.
@Entity
public class Cliente {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
    @GenericGenerator(name="native", strategy = "native")
    private long Id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private String telefone;




    //Getters and Setters permitem os accesos aos entities

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Id == cliente.Id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
