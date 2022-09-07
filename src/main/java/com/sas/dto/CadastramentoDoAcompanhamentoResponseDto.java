package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import com.sas.entity.CadastramentoDoAcompanhamento;

public class CadastramentoDoAcompanhamentoResponseDto {
	
	@Column(name = "id")
	private Long id;
	
    @Column(name = "dataInicial")
	private Date dataInicial;
    
    @Column(name = "diasemana")
    private String diasemana;
    
    @Column(name = "turno")
    private String turno;
	
	public CadastramentoDoAcompanhamentoResponseDto(Long id, Date dataInicial, String diasemana, String turno) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.diasemana = diasemana;
		this.turno = turno;
	}

   public static CadastramentoDoAcompanhamentoResponseDto converterCadastramentoDoAcompanhamentoParaCadastramentoDoAcompanhamentotoResponseDto(CadastramentoDoAcompanhamento cadastramentoDoAcompanhamento) {
	   return new CadastramentoDoAcompanhamentoResponseDto(cadastramentoDoAcompanhamento.getId(), cadastramentoDoAcompanhamento.getDataInicial(), cadastramentoDoAcompanhamento.getDiasemana(), cadastramentoDoAcompanhamento.getTurno());
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
   
   
	
	
	
	
	
	
    
    

