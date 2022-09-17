package com.sas.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cadastramentoDoAcompanhamento")
public class CadastramentoDoAcompanhamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date dataInicial;
	private String diasemana;
	private String turno;

	@ManyToOne
	@JoinColumn(name = "id_creas", referencedColumnName = "id")
	private Creas creas;

	@ManyToOne
	@JoinColumn(name = "id_unidade", referencedColumnName = "id")
	private UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagem;

	@ManyToOne
	@JoinColumn(name = "id_tipo_de_acao", referencedColumnName = "id")
	private TipoDeAcao tipoDeAcao;

	@ManyToOne
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;

	public CadastramentoDoAcompanhamento() {
	}

     public CadastramentoDoAcompanhamento(Long id, Date dataInicial, String diasemana, String turno, Creas creas,
			UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagem, TipoDeAcao tipoDeAcao, Pessoa pessoa,
			Usuario usuario) {
		super();
		this.id = id;
		this.dataInicial = dataInicial;
		this.diasemana = diasemana;
		this.turno = turno;
		this.creas = creas;
		this.unidadeEspecificaDeAbordagem = unidadeEspecificaDeAbordagem;
		this.tipoDeAcao = tipoDeAcao;
		this.pessoa = pessoa;
		this.usuario = usuario;
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

	public Creas getCreas() {
		return creas;
	}

	public void setCreas(Creas creas) {
		this.creas = creas;
	}

	public UnidadeEspecificaDeAbordagem getUnidadeEspecificaDeAbordagem() {
		return unidadeEspecificaDeAbordagem;
	}

	public void setUnidadeEspecificaDeAbordagem(UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagem) {
		this.unidadeEspecificaDeAbordagem = unidadeEspecificaDeAbordagem;
	}

	public TipoDeAcao getTipoDeAcao() {
		return tipoDeAcao;
	}

	public void setTipoDeAcao(TipoDeAcao tipoDeAcao) {
		this.tipoDeAcao = tipoDeAcao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
