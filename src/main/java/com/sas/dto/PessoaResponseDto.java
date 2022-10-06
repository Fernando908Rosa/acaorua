package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.sas.entity.Pessoa;
import com.sas.enums.Genero;

public class PessoaResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
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
	@Enumerated(EnumType.STRING)
	private Genero genero;

	public PessoaResponseDto(Long id, String nome, String sobrenome, Date dataInicial, Integer cpf, String nomepai,
			String nomemae, Genero genero) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataInicial = dataInicial;
		this.cpf = cpf;
		this.nomepai = nomepai;
		this.nomemae = nomemae;
		this.genero = genero;
	}

	public static PessoaResponseDto converterPessoaParaPessoaResponseDto(Pessoa pessoa) {
		return new PessoaResponseDto( pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getDataInicial(), pessoa.getCpf(), pessoa.getNomepai(), pessoa.getNomemae(), pessoa.getGenero());
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

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}


