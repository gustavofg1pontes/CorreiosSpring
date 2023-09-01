package com.gustavo.Correios2.controllers;

import com.gustavo.Correios2.dtos.PessoaDTO;
import com.gustavo.Correios2.models.Endereco;
import com.gustavo.Correios2.models.Pessoa;
import com.gustavo.Correios2.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping(value = "/cadastro")
    public void save(@RequestBody PessoaDTO pessoa){
        this.pessoaService.save(pessoa);
    }

    @GetMapping(value = "/{id}")
    public PessoaDTO findById(@PathVariable Long id){
        return pessoaService.findById(id);
    }

    @GetMapping
    public List<PessoaDTO> findAll(){
        return pessoaService.findAll();
    }
}
