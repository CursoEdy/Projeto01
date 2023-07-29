package com.edyalves.projeto01;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edyalves.projeto01.domain.Categoria;
import com.edyalves.projeto01.domain.Cidade;
import com.edyalves.projeto01.domain.Curso;
import com.edyalves.projeto01.domain.Endereco;
import com.edyalves.projeto01.domain.Estado;
import com.edyalves.projeto01.domain.Experiencia;
import com.edyalves.projeto01.domain.Habilidade;
import com.edyalves.projeto01.domain.Usuario;
import com.edyalves.projeto01.repositories.CategoriaRepository;
import com.edyalves.projeto01.repositories.CidadeRepository;
import com.edyalves.projeto01.repositories.CursoRepository;
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
	@Autowired
	private CursoRepository formacaoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(Projeto01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Saúde");
		Categoria cat2 = new Categoria(null, "Técnologia");
		Categoria cat3 = new Categoria(null, "Desenvolvimento Social");
		Categoria cat4 = new Categoria(null, "Educação");
		Categoria cat5 = new Categoria(null, "Turismo");
		
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
		
		Curso curso1 = new Curso(null, "Analise e desenvolvimento de sistema", cat2);
		Curso curso2 = new Curso(null, "Ciência da computação", cat2);
		Curso curso3 = new Curso(null, "Técnico de Enfermagem", cat1);
		Curso curso4 = new Curso(null, "Agente de aeroporto", cat5);
		Curso curso5 = new Curso(null, "Agente de desenvolvimento local", cat3);
		Curso curso6 = new Curso(null, "Educador nfantil", cat4);
		
		cat1.getCursos().addAll(Arrays.asList(curso3));
		cat2.getCursos().addAll(Arrays.asList(curso1, curso2));
		cat3.getCursos().addAll(Arrays.asList(curso5));
		cat4.getCursos().addAll(Arrays.asList(curso6));
		cat5.getCursos().addAll(Arrays.asList(curso4));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));
		formacaoRepository.saveAll(Arrays.asList(curso1,curso2, curso3, curso4, curso5, curso6));
		habilidadeRepository.saveAll(Arrays.asList(hab1, hab2));
		experienciaRepository.saveAll(Arrays.asList(exp1, exp2));
	}

}
