package com.edyalves.projeto01.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Experiencia implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String cargo;
	private String descricao;
	private Date inicio;
	private Date termino;
	
	@ManyToOne
	@JoinColumn(name ="usuario_id")
	private Usuario experienciaDoUsuario;
	
	public Experiencia() {}

	public Experiencia(Integer id, String nome, String cargo, String descricao, Date inicio, Date termino, Usuario experienciaDoUsuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.descricao = descricao;
		this.inicio = inicio;
		this.termino = termino;
		this.experienciaDoUsuario = experienciaDoUsuario;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public Usuario getExperienciaDoUsuario() {
		return experienciaDoUsuario;
	}

	public void setExperienciaDoUsuario(Usuario experienciaDoUsuario) {
		this.experienciaDoUsuario = experienciaDoUsuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Experiencia other = (Experiencia) obj;
		return Objects.equals(id, other.id);
	}
}
