package com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.entity.CadastramentoDoAcompanhamento;

@Repository
public interface CadastramentoDoAcompanhamentoRepository extends JpaRepository<CadastramentoDoAcompanhamento, Long> {
	

}
