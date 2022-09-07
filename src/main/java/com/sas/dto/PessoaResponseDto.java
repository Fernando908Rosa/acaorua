package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.Pessoa;

public class PessoaResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "datadenascimento")
	private String datadenascimento;
	
	@Column(name = "cpf")
	private Integer cpf;

	public PessoaResponseDto(Long id,String nome, String sobrenome, String datadenascimento, Integer cpf) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datadenascimento = datadenascimento;
		this.cpf = cpf;
	}
	
	public static PessoaResponseDto converterPessoaParaPessoaResponseDto(Pessoa pessoa) {
		return new PessoaResponseDto( pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getDatanascimento(), pessoa.getCpf());
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


	public String getDatadenascimento() {
		return datadenascimento;
	}


	public void setDatadenascimento(String datadenascimento) {
		this.datadenascimento = datadenascimento;
	}


	public Integer getCpf() {
		return cpf;
	}


	public void setCpf(Integer cpf) {
		this.cpf = cpf;


	}
	
}


