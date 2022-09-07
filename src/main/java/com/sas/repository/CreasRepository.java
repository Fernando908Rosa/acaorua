package com.sas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sas.entity.Creas;

@Repository
public interface CreasRepository extends JpaRepository<Creas, Long> {

}
