package com.gustavo.Correios2.services;

import com.gustavo.Correios2.dtos.PessoaDTO;
import com.gustavo.Correios2.exceptions.InvalidFieldValueException;
import com.gustavo.Correios2.models.Cep;
import com.gustavo.Correios2.models.Endereco;
import com.gustavo.Correios2.models.Pessoa;
import com.gustavo.Correios2.providers.CepProvider;
import com.gustavo.Correios2.repositories.EnderecoRepository;
import com.gustavo.Correios2.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    public void save(PessoaDTO pessoa) {
        Cep cep = CepProvider.fetchAddressInfoByCep(pessoa.getEndereco().getCep());
        Endereco endereco = new Endereco(pessoa.getEndereco());
        endereco.changeUsingCep(cep);
        Pessoa pessoa1 = new Pessoa(pessoa.getNome(), pessoa.getTelefone(), pessoa.getEmail(), endereco);
        pessoa1.getEndereco().setPessoa(pessoa1);
        if (pessoa1.validarPessoa() != null) {
            System.out.println(pessoa1.getEndereco().getCep());
            throw new InvalidFieldValueException(pessoa1.validarPessoa());
        } else {
            this.pessoaRepository.save(pessoa1);
            this.enderecoRepository.save(pessoa1.getEndereco());
        }
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll() {
        return pessoaRepository.findAll().stream().map(PessoaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id) {
        return new PessoaDTO(pessoaRepository.findById(id).get());
    }
}
