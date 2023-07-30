package com.edyalves.projeto01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edyalves.projeto01.domain.Curso;
import com.edyalves.projeto01.repositories.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository repo;
	
	public Curso find(Integer id) {
		Optional<Curso> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
