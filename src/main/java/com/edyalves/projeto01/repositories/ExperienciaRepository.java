package com.edyalves.projeto01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edyalves.projeto01.domain.Experiencia;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{

}
