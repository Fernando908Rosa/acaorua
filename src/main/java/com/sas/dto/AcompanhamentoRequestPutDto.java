package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import com.sas.entity.Acompanhamento;
import com.sas.entity.Creas;
import com.sas.entity.Pessoa;
import com.sas.entity.TipoDeAcao;
import com.sas.entity.Unidade;
import com.sas.entity.Usuario;

public class AcompanhamentoRequestPutDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "dataInicial")
	private Date dataInicial;
	
	@Column(name = "diasemana")
	private String diasemana;
	
	@Column(name = "turno")
	private String turno;
	
	public Acompanhamento converterParaEntidadeAcompanhamento(Long idCreas, Long  idUnidade, Long idTipoDeAcao, Long idPessoa, Long idUsuario) { 
		return new Acompanhamento(id, dataInicial, diasemana, turno,  new Creas(idCreas), new Unidade(idUnidade), new TipoDeAcao(idTipoDeAcao), new Pessoa(idPessoa), new Usuario(idUsuario));
		
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
