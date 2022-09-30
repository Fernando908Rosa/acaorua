package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import com.sas.entity.Acompanhamento;
import com.sas.entity.Creas;
import com.sas.entity.Pessoa;
import com.sas.entity.TipoDeAcao;
import com.sas.entity.Unidade;
import com.sas.entity.Usuario;

public class AcompanhamentoResponseDto {
	
	@Column(name = "id")
	private Long id;
	
    @Column(name = "dataInicial")
	private Date dataInicial;
    
    @Column(name = "diasemana")
    private String diasemana;
    
    @Column(name = "turno")
    private String turno;
    
    @Column(name = "id_creas")
    private Creas idcreas;
    
    @Column(name = "id_pessoa")
    private Pessoa idpessoa;
    
    @Column(name = "id_tipo_de_acao")
    private TipoDeAcao idTipoDeAcao;
    
    @Column(name = "id_unidade")
    private Unidade idunidade;
    
    @Column(name = "id_usuario")
    private Usuario idusuario;

   public AcompanhamentoResponseDto(Long id, Date dataInicial, String diasemana, String turno,
			Creas creas, Pessoa pessoa, TipoDeAcao tipoDeAcao, Unidade unidade, Usuario usuario) {
		this.id = id;
		this.dataInicial = dataInicial;
		this.diasemana = diasemana;
		this.turno = turno;
		this.idcreas = creas;
		this.idpessoa = pessoa;
		this.idTipoDeAcao = tipoDeAcao;
		this.idunidade = unidade;
		this.idusuario = usuario;
	}

   public static AcompanhamentoResponseDto converterAcompanhamentoParaAcompanhamentotoResponseDto(Acompanhamento Acompanhamento) {
	   return new AcompanhamentoResponseDto(Acompanhamento.getId(), Acompanhamento.getDataInicial(), Acompanhamento.getDiasemana(), Acompanhamento.getTurno(), Acompanhamento.getCreas(), Acompanhamento.getPessoa(),Acompanhamento.getTipoDeAcao(), Acompanhamento.getUnidade(),Acompanhamento.getUsuario());
   

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

   public Creas getIdcreas() {
	return idcreas;
   }

   public void setIdcreas(Creas idcreas) {
	this.idcreas = idcreas;
   }

   public Pessoa getIdpessoa() {
	return idpessoa;
   }

   public void setIdpessoa(Pessoa idpessoa) {
	this.idpessoa = idpessoa;
   }

   public TipoDeAcao getIdTipoDeAcao() {
	return idTipoDeAcao;
   }

   public void setIdTipoDeAcao(TipoDeAcao idTipoDeAcao) {
	this.idTipoDeAcao = idTipoDeAcao;
   }

   public Unidade getIdunidade() {
	return idunidade;
   }

   public void setIdunidade(Unidade idunidade) {
	this.idunidade = idunidade;
   }

   public Usuario getIdusuario() {
	return idusuario;
   }

   public void setIdusuario(Usuario idusuario) {
	this.idusuario = idusuario;
   }

}
   
   
	
	
	
	
	
	
    
    

