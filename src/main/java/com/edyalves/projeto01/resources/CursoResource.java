package com.edyalves.projeto01.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edyalves.projeto01.domain.Curso;
import com.edyalves.projeto01.services.CursoService;

@RestController
@RequestMapping(value = "/cursos")
public class CursoResource {
	
	@Autowired
	private CursoService service;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Curso> find(@PathVariable Integer id) {
		Curso obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
