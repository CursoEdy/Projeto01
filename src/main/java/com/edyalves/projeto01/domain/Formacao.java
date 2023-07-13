package com.edyalves.projeto01.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.edyalves.projeto01.domain.enums.EstadoFormacao;

@Entity
public class Formacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private String termino;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Usuario usuario;
	
	public Formacao() {}

	public Formacao(Integer id, String nome, String descricao, String termino, EstadoFormacao status, Usuario usuario) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.termino = termino;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public EstadoFormacao getStatus() {
		return EstadoFormacao.toEnum(status);
	}

	public void setStatus(EstadoFormacao status) {
		this.status = status.getCod();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formacao other = (Formacao) obj;
		return Objects.equals(id, other.id);
	}
}
