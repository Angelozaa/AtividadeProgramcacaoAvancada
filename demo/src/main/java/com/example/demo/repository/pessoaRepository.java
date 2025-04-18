package com.example.demo.repository;

import com.example.demo.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pessoaRepository extends JpaRepository<PessoaModel, Long> {
}