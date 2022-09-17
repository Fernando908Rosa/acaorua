package com.sas.dto;

import javax.persistence.Column;

import org.hibernate.validator.constraints.Length;

import com.sas.entity.Usuario;

public class UsuarioRequest {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	@Length(min = 5, max = 70, message = "digite nome corretamente entre 5 a 70 caracteres")
	private  String nome;
	
	@Column(name = "sobrenome")
	private  String sobrenome;
	
	@Column(name = "datanascimento")
	private  String datanascimento;
	
	@Column(name = "cpf")
	private Integer cpf;
	
	public Usuario converterUsuarioRequestDtoParaEntidadeUsuario() {
		return new Usuario(null, nome, sobrenome, datanascimento, cpf);
		
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

	public String getDatanascimento() {
		return datanascimento;
	}

	public void setDatanascimento(String datanascimento) {
		this.datanascimento = datanascimento;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	
	}

}
