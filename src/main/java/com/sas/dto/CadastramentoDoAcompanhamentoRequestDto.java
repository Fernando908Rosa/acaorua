package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import com.sas.entity.CadastramentoDoAcompanhamento;
import com.sas.entity.Creas;
import com.sas.entity.Pessoa;
import com.sas.entity.TipoDeAcao;
import com.sas.entity.UnidadeEspecificaDeAbordagem;
import com.sas.entity.Usuario;

public class CadastramentoDoAcompanhamentoRequestDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dataInicial")
	private Date dataInicial;
	
	@Column(name = "diasemana")
	private String diasemana; 
	
	@Column(name = "turno")
	private String turno;
	
		
	public CadastramentoDoAcompanhamento converterCadastramentoDoAcompanhamentoRequestDtoParaEntidadeCadastramentoDoAcompanhamento(Long idCreas, Long  idUnidade, Long idTipoDeAcao, Long idPessoa, Long idUsuario) {
		return new CadastramentoDoAcompanhamento(null, dataInicial, diasemana, turno, new Creas(idCreas), new UnidadeEspecificaDeAbordagem(idUnidade), new TipoDeAcao(idTipoDeAcao), new Pessoa(idPessoa), new Usuario(idUsuario));

	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDiasemana() {
		return diasemana;
	}

	public void setDiasemana(String diasemana) {
		this.diasemana = diasemana;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
    	
}
    
    