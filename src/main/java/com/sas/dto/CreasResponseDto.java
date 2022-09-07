package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.Creas;

public class CreasResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	public CreasResponseDto(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public static CreasResponseDto converterCreasParaCreasResponseDto(Creas creas) {
		return new CreasResponseDto( creas.getId(), creas.getNome());
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
