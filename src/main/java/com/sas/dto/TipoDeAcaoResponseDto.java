package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.TipoDeAcao;

public class TipoDeAcaoResponseDto {
	
	@Column(name = "id")
	private Long Id;
	
	@Column(name = "nameTipoDeAcao")
	private  String nameTipoDeAcao;

	public TipoDeAcaoResponseDto(Long id, String nameTipoDeAcao) {
		Id = id;
		this.nameTipoDeAcao = nameTipoDeAcao;
	}

	public static TipoDeAcaoResponseDto converterTipoDeAcaoParaTipoDeAcaoResponseDto(TipoDeAcao tipoDeAcao) {
		return new TipoDeAcaoResponseDto(tipoDeAcao.getId(), tipoDeAcao.getNameTipoDeacao());
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNameTipoDeAcao() {
		return nameTipoDeAcao;
	}

	public void setNameTipoDeAcao(String nameTipoDeAcao) {
		this.nameTipoDeAcao = nameTipoDeAcao;
	}
}
