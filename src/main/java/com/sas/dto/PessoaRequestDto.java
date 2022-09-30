package com.sas.dto;

import java.util.Date;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

import com.sas.entity.Pessoa;

public class PessoaRequestDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	@Length(min = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private  String nome;
	
	@Column(name = "sobrenome")
	private  String sobrenome;
	
	@Column(name = "dataInicial")
	private  Date dataInicial;
	
	@Column(name = "cpf")
	private Integer cpf;
	
	public Pessoa converterPessoaRequestDtoParaEntidadePessoa() {
		return new Pessoa(id, nome, sobrenome, dataInicial, cpf);			
				
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

}	



