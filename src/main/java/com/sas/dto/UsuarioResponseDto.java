package com.sas.dto;

import javax.persistence.Column;

import com.sas.entity.Usuario;

public class UsuarioResponseDto {
	
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "datanascimento")
	private String datanascimento;
	
	@Column(name = "cpf")
	private Integer cpf;

	public UsuarioResponseDto(Long id,String nome, String sobrenome, String datanascimento, Integer cpf) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
	}
	
	public static UsuarioResponseDto converterUsuarioParaUsuarioResponseDto(Usuario usuario) {
		return new UsuarioResponseDto( usuario.getId(), usuario.getNome(), usuario.getSobrenome(), usuario.getDatanascimento(), usuario.getCpf());
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


