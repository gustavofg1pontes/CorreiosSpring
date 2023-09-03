package com.gustavo.Correios2.dtos;

import com.gustavo.Correios2.models.Endereco;
import com.gustavo.Correios2.models.Pessoa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class EnderecoDTO {
    private String cep;
    private String estado;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;
    private String rua;

    public EnderecoDTO(String cep, String estado, String cidade, String bairro, String complemento, String numero, String rua) {
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.complemento = complemento;
        this.numero = numero;
        this.rua = rua;
    }
    public EnderecoDTO(Endereco endereco) {
        BeanUtils.copyProperties(endereco, this);
    }
}
