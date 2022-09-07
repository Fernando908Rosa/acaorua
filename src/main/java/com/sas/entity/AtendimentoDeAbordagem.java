package com.sas.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "tb_AtendimentoDeAbordagem")
public class AtendimentoDeAbordagem {
	
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String nome;

}
