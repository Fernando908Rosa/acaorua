package com.sas.dto;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

import com.sas.entity.UnidadeEspecificaDeAbordagem;

public class UnidadeEspecificaDeAbordagemRequestDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	@Length(min  = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private String nome;
	
	public UnidadeEspecificaDeAbordagem converterUnidadeEspecificaDeAbordagemRequestDtoParaEntidadeUnidadeEspecificaDeAbordagem( ) {
		return new UnidadeEspecificaDeAbordagem(id, nome);
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
