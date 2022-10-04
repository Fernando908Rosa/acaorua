package com.sas.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String sobrenome;
	private Date dataInicial;
	private Integer cpf;
	private String nomepai;
	private String nomemae;
	private String genero;
	
	public Pessoa(Long id, String nome, String sobrenome, Date dataInicial, Integer cpf, String nomepai, String nomemae,
			String genero) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataInicial = dataInicial;
		this.cpf = cpf;
		this.nomepai = nomepai;
		this.nomemae = nomemae;
		this.genero = genero;
	}

	public Pessoa() {
	}

	public Pessoa(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataInicial=" + dataInicial
				+ ", cpf=" + cpf + ", nomepai=" + nomepai + ", nomemae=" + nomemae + ", genero=" + genero + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataInicial, genero, id, nome, nomemae, nomepai, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataInicial, other.dataInicial)
				&& Objects.equals(genero, other.genero) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomemae, other.nomemae)
				&& Objects.equals(nomepai, other.nomepai) && Objects.equals(sobrenome, other.sobrenome);
	}	
	
}
	
	
	
	


