package com.gustavo.Correios2.repositories;

import com.gustavo.Correios2.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
