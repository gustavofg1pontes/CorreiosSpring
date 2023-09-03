package com.gustavo.Correios2.repositories;

import com.gustavo.Correios2.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
