package com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.entity.UnidadeEspecificaDeAbordagem;

@Repository
public interface UnidadeEspecificaDeAbordagemRepository extends JpaRepository<UnidadeEspecificaDeAbordagem, Long> {

}
