package com.edyalves.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edyalves.projeto01.domain.Formacao;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Integer>{
}
