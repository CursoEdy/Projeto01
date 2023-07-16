package com.edyalves.projeto01;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edyalves.projeto01.domain.Cidade;
import com.edyalves.projeto01.domain.Endereco;
import com.edyalves.projeto01.domain.Estado;
import com.edyalves.projeto01.domain.Experiencia;
import com.edyalves.projeto01.domain.Habilidade;
import com.edyalves.projeto01.domain.Usuario;
import com.edyalves.projeto01.repositories.CidadeRepository;
import com.edyalves.projeto01.repositories.EndereçoRepository;
import com.edyalves.projeto01.repositories.EstadoRepository;
import com.edyalves.projeto01.repositories.ExperienciaRepository;
import com.edyalves.projeto01.repositories.HabilidadeRepository;
import com.edyalves.projeto01.repositories.UsuarioRepository;

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
	@Autowired
	private EndereçoRepository enderecoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(Projeto01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "São Paulo", est1);
		Cidade cid2 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(cid1,cid2));
		
		estadoRepository.saveAll(Arrays.asList(est1));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2));
		
		Endereco end1 = new Endereco(null, "Endereço 01", "01", "Bairro 01", "12548-150", cid2);
		Endereco end2 = new Endereco(null, "Endereço 01", "01", "Bairro 01", "12548-150", cid1);
		
		Usuario user1 = new Usuario(null, "User 1", "email1@gmail.com", end1);
		Usuario user2 = new Usuario(null, "User 2", "email2@gmail.com", end2);
		
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		
		Habilidade hab1 = new Habilidade(null, "Java");
		Habilidade hab2 = new Habilidade(null, "Orientação a objeto");
		
		Experiencia exp1 = new Experiencia(null, "Experiência 1", "Cargo 1", "Descrição 1", sdf.parse("01/03/2015"), sdf.parse("15/05/2019"));
		Experiencia exp2 = new Experiencia(null, "Experiência 2", "Cargo 2", "Descrição 2", sdf.parse("20/07/2019"), sdf.parse("06/07/2020"));
		
		habilidadeRepository.saveAll(Arrays.asList(hab1, hab2));
		experienciaRepository.saveAll(Arrays.asList(exp1, exp2));
	}

}
