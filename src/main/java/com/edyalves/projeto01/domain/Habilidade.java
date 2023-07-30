package com.edyalves.projeto01.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Habilidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario habilidadeDoUsuario;
	
	public Habilidade() {}

	public Habilidade(Integer id, String nome, Usuario habilidadeDoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.habilidadeDoUsuario = habilidadeDoUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getHabilidadeDoUsuario() {
		return habilidadeDoUsuario;
	}

	public void setHabilidadeDoUsuario(Usuario habilidadeDoUsuario) {
		this.habilidadeDoUsuario = habilidadeDoUsuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habilidade other = (Habilidade) obj;
		return Objects.equals(id, other.id);
	}
}
