package com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.entity.Acompanhamento;

@Repository
public interface AcompanhamentoRepository extends JpaRepository<Acompanhamento, Long> {
	

}
