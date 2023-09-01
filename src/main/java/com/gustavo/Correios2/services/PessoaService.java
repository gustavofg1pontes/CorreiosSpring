package com.gustavo.Correios2.services;

import com.gustavo.Correios2.dtos.PessoaDTO;
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

    public void save(PessoaDTO pessoa){
        Cep cep = CepProvider.fetchAddressInfoByCep(pessoa.getCep());
        Pessoa pessoa1 = new Pessoa(pessoa.getCep(), pessoa.getNome(), pessoa.getTelefone(), pessoa.getEmail(), pessoa.getEndereco());
        pessoa1.getEndereco().setPessoa(pessoa1);
        pessoa1.getEndereco().changeUsingCep(cep);
        this.enderecoRepository.save(pessoa1.getEndereco());
        this.pessoaRepository.save(pessoa1);
    }

    @Transactional(readOnly = true)
    public List<PessoaDTO> findAll(){
        return pessoaRepository.findAll().stream().map(PessoaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public PessoaDTO findById(Long id){
        return new PessoaDTO(pessoaRepository.findById(id).get());
    }
}
