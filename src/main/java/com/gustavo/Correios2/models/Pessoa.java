package com.gustavo.Correios2.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_pessoa")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    private String nome;
    private String telefone;
    private String email;
    @OneToOne(mappedBy = "pessoa", fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = false)
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String cep, String nome, String telefone, String email, Endereco endereco) {
        this.cep = cep;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }
}
