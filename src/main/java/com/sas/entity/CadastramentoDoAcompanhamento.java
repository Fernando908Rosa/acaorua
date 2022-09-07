package com.sas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cadastramentoDoAcompanhamento")
public class CadastramentoDoAcompanhamento {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id;
	private Date dataInicial;
	private String diasemana;
	private String turno;

	public CadastramentoDoAcompanhamento( Long id, Date dataInicial, String diasemana, String turno) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.diasemana = diasemana;
		this.turno = turno;
	}

	public CadastramentoDoAcompanhamento() {
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
	