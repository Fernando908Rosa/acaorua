package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.Unidade;

public class UnidadeResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	public UnidadeResponseDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static UnidadeResponseDto converterUnidadeParaUnidadeResponseDto(Unidade unidade) {
		return new UnidadeResponseDto(unidade.getId(), unidade.getNome());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
