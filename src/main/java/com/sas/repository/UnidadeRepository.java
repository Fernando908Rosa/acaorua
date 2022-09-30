package com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.entity.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {

}
