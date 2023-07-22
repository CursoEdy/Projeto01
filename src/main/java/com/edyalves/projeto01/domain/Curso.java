package com.edyalves.projeto01.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.edyalves.projeto01.domain.enums.EstadoCurso;

@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String duracao;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name ="usuario_id")
	private Usuario usuario;
	
	public Curso() {}

	public Curso(Integer id, String nome, String duracao, EstadoCurso status, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.duracao = duracao;
		this.status = (status==null) ? null : status.getCod();
		this.usuario = usuario;
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

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public EstadoCurso getStatus() {
		return EstadoCurso.toEnum(status);
	}

	public void setStatus(EstadoCurso status) {
		this.status = status.getCod();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}
}
