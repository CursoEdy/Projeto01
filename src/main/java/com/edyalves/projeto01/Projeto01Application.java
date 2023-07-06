package com.edyalves.projeto01;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edyalves.projeto01.domain.Cidade;
import com.edyalves.projeto01.domain.Estado;
import com.edyalves.projeto01.domain.Experiencia;
import com.edyalves.projeto01.domain.Habilidade;
import com.edyalves.projeto01.repositories.CidadeRepository;
import com.edyalves.projeto01.repositories.EstadoRepository;
import com.edyalves.projeto01.repositories.ExperienciaRepository;
import com.edyalves.projeto01.repositories.HabilidadeRepository;

@SpringBootApplication
public class Projeto01Application implements CommandLineRunner{
	
	@Autowired
	private HabilidadeRepository habilidadeRepository;
	@Autowired
	private ExperienciaRepository experienciaRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(Projeto01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Habilidade hab1 = new Habilidade(null, "Java");
		Habilidade hab2 = new Habilidade(null, "Orientação a objeto");
		
		Experiencia exp1 = new Experiencia(null, "Experiência 1", "Cargo 1", "Descrição 1", sdf.parse("01/03/2015"), sdf.parse("15/05/2019"));
		Experiencia exp2 = new Experiencia(null, "Experiência 2", "Cargo 2", "Descrição 2", sdf.parse("20/07/2019"), sdf.parse("06/07/2020"));
		
		habilidadeRepository.saveAll(Arrays.asList(hab1, hab2));
		experienciaRepository.saveAll(Arrays.asList(exp1, exp2));
		
		Estado est1 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
	}

}
