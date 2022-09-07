package com.sas.dto;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

import com.sas.entity.TipoDeAcao;

public class TipoDeAcaoRequestDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nameTipoDeAcao")
	@Length(min = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private String nameTipoDeAcao;
	
	public TipoDeAcao converterTipoDeAcaoRequestDtoParaEntidadeTipoDeAcao() {
		return new TipoDeAcao(id, nameTipoDeAcao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameTipoDeAcao() {
		return nameTipoDeAcao;
	}

	public void setNameTipoDeAcao(String nameTipoDeAcao) {
		this.nameTipoDeAcao = nameTipoDeAcao;
	}
	
}
