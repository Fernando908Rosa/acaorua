package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.UnidadeEspecificaDeAbordagem;

public class UnidadeEspecificaDeAbordagemResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	public UnidadeEspecificaDeAbordagemResponseDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static UnidadeEspecificaDeAbordagemResponseDto converterUnidadeEspecificaDeAbordagemParaUnidadeEspecificaDeAbordagemResponseDto(UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagem) {
		return new UnidadeEspecificaDeAbordagemResponseDto(unidadeEspecificaDeAbordagem.getId(), unidadeEspecificaDeAbordagem.getNome());
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
