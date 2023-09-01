package com.gustavo.Correios2.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String rua;
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    public Endereco() {

    }

    public Endereco(Pessoa pessoa, String cep, String estado, String cidade, String bairro, String complemento, String numero, String rua) {
        this.pessoa = pessoa;
        this.pessoa.setCep(cep);
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.rua = rua;
    }

    public Endereco(Cep cep, Pessoa pessoa, String complemento, String numero){
        this.pessoa = pessoa;
        this.pessoa.setCep(cep.getCep());
        this.estado = cep.getState();
        this.cidade = cep.getCity();
        this.bairro = cep.getNeighborhood();
        this.rua = cep.getStreet();
        this.complemento = complemento;
        this.numero = numero;
    }

    public void changeUsingCep(Cep cep){
        this.pessoa.setCep(cep.getCep());
        this.estado = cep.getState();
        this.cidade = cep.getCity();
        this.bairro = cep.getNeighborhood();
        this.rua = cep.getStreet();
    }

}
