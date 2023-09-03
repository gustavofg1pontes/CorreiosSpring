package com.gustavo.Correios2.models;


import com.gustavo.Correios2.dtos.EnderecoDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.regex.Pattern;

@Entity
@Table(name = "tb_endereco")
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String rua;

    @OneToOne(mappedBy = "endereco", fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

    public Endereco() {

    }

    public Endereco(Pessoa pessoa, String cep, String estado, String cidade, String bairro, String complemento, String numero, String rua) {
        this.pessoa = pessoa;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.rua = rua;
    }
    public Endereco(EnderecoDTO enderecoDTO){
        BeanUtils.copyProperties(enderecoDTO, this);
    }

    public Endereco(Cep cep, Pessoa pessoa, String complemento, String numero){
        this.pessoa = pessoa;
        this.cep = cep.getCep();
        this.estado = cep.getState();
        this.cidade = cep.getCity();
        this.bairro = cep.getNeighborhood();
        this.rua = cep.getStreet();
        this.complemento = complemento;
        this.numero = numero;
    }

    public void changeUsingCep(Cep cep){
        this.cep = cep.getCep();
        this.estado = cep.getState();
        this.cidade = cep.getCity();
        this.bairro = cep.getNeighborhood();
        this.rua = cep.getStreet();
    }

    public boolean validateCep(){
        Pattern pattern = Pattern.compile("\\d{8}");
        boolean cepValido = pattern.matcher(cep).find();
        return cepValido;
    }

}
