package com.sas.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipodeacao")
public class TipoDeAcao { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameTipoDeacao;
	
	public TipoDeAcao(Long id, String nameTipoDeacao) {
		this.id = id;
		this.nameTipoDeacao = nameTipoDeacao;
	}

	public TipoDeAcao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameTipoDeacao() {
		return nameTipoDeacao;
	}

	public void setNameTipoDeacao(String nameTipoDeacao) {
		this.nameTipoDeacao = nameTipoDeacao;
	}

	@Override
	public String toString() {
		return "TipoDeAcao [id=" + id + ", nameTipoDeacao=" + nameTipoDeacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nameTipoDeacao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDeAcao other = (TipoDeAcao) obj;
		return Objects.equals(id, other.id) && Objects.equals(nameTipoDeacao, other.nameTipoDeacao);
	}
	
}	
	
	
	
	
	
	


