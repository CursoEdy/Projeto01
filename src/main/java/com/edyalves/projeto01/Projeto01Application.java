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
import com.edyalves.projeto01.domain.Formacao;
import com.edyalves.projeto01.domain.Habilidade;
import com.edyalves.projeto01.domain.Usuario;
import com.edyalves.projeto01.domain.enums.EstadoFormacao;
import com.edyalves.projeto01.repositories.CidadeRepository;
import com.edyalves.projeto01.repositories.EndereçoRepository;
import com.edyalves.projeto01.repositories.EstadoRepository;
import com.edyalves.projeto01.repositories.ExperienciaRepository;
import com.edyalves.projeto01.repositories.FormacaoRepository;
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
	@Autowired
	private FormacaoRepository formacaoRepository;
	
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
		
		Usuario user1 = new Usuario(null, "User 1", "email1@gmail.com");
		Usuario user2 = new Usuario(null, "User 2", "email2@gmail.com");
		
		Endereco end1 = new Endereco(null, "Endereço 01", "01", "Bairro 01", "12548-150", cid2, user1);
		Endereco end2 = new Endereco(null, "Endereço 01", "01", "Bairro 01", "12548-150", cid1, user2);
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		
		Habilidade hab1 = new Habilidade(null, "Java", user1);
		Habilidade hab2 = new Habilidade(null, "Orientação a objeto", user2);
		
		user1.getHabilidades().addAll(Arrays.asList(hab1));
		user2.getHabilidades().addAll(Arrays.asList(hab2));
		
		Experiencia exp1 = new Experiencia(null, "Experiência 1", "Cargo 1", "Descrição 1", sdf.parse("01/03/2015"), sdf.parse("15/05/2019"), user1);
		Experiencia exp2 = new Experiencia(null, "Experiência 2", "Cargo 2", "Descrição 2", sdf.parse("20/07/2019"), sdf.parse("06/07/2020"), user2);
		
		user1.getExperiencia().addAll(Arrays.asList(exp1));
		user2.getExperiencia().addAll(Arrays.asList(exp2));
		
		Formacao form1 = new Formacao(null, "Analise e desenvolvimento de sistema","Duração 2 anos", EstadoFormacao.COMPLETO, user1);
		Formacao form2 = new Formacao(null, "Ciência da computação","Duração 4 anos", EstadoFormacao.CURSANDO, user2);
		
		formacaoRepository.saveAll(Arrays.asList(form1, form2));
		habilidadeRepository.saveAll(Arrays.asList(hab1, hab2));
		experienciaRepository.saveAll(Arrays.asList(exp1, exp2));
	}

}
