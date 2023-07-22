package com.edyalves.projeto01.domain.enums;

public enum EstadoCurso {
	
	CURSANDO(1, "Cursando"),
	COMPLETO(2, "Completo"),
	INCOMPLETO(3, "Incompleto");
	
	private int cod;
	private String descricao;
	
	private EstadoCurso(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static EstadoCurso toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (EstadoCurso x : EstadoCurso.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
		
	}
	
}
