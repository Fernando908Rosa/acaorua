package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

import com.sas.entity.Pessoa;


public class PessoaRequestPutDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	@Length(min = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "dataInicial")
	private Date dataInicial;
	
	@Column(name = "cpf")
	private Integer cpf;
	
	@Column(name = "nomepai")
	private String nomepai;
	
	@Column(name = "nomemae")
	private String nomemae;
	
	@Column(name = "genero")
	private String genero;
	
	public Pessoa converterParaEntidadePessoa() {
		return new Pessoa(id, nome, sobrenome, dataInicial, cpf, nomepai, nomemae, genero);
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomepai() {
		return nomepai;
	}

	public void setNomepai(String nomepai) {
		this.nomepai = nomepai;
	}

	public String getNomemae() {
		return nomemae;
	}

	public void setNomemae(String nomemae) {
		this.nomemae = nomemae;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}	

