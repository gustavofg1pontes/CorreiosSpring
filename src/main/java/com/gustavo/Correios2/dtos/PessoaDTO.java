package com.gustavo.Correios2.dtos;

import com.gustavo.Correios2.models.Endereco;
import com.gustavo.Correios2.models.Pessoa;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class PessoaDTO {
    private String nome;
    private String telefone;
    private String email;
    private EnderecoDTO endereco;

    public PessoaDTO() {
    }

    public PessoaDTO(String nome, String telefone, String email, EnderecoDTO endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public PessoaDTO(Pessoa pessoa) {
        BeanUtils.copyProperties(pessoa, this);
        this.endereco = new EnderecoDTO(pessoa.getEndereco());
    }
}
