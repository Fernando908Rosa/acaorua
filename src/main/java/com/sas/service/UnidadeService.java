package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.Unidade;
import com.sas.repository.UnidadeRepository;

@Service
public class UnidadeService {
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<Unidade> ListarUnidade() {
		return unidadeRepository.findAll();
	}
	
	public Optional<Unidade> buscarPorId(Long id) {
		return unidadeRepository.findById(id);
	}
	
	public Unidade salvar(Unidade unidade) {
		return unidadeRepository.save(unidade);
	}
	
	public Unidade atualizar(Long id, Unidade unidadeSalvar) {
		Unidade unidadeVaiSerAtualizada = validarUnidadeExiste(id);
		BeanUtils.copyProperties(unidadeSalvar, unidadeVaiSerAtualizada, "id");
		return unidadeRepository.save(unidadeVaiSerAtualizada);
	}
	
	public void deletar(Long id) {
		unidadeRepository.deleteById(id);
	}
	
	private Unidade validarUnidadeExiste(Long id) {
		Optional<Unidade> unidade = buscarPorId(id);
		if(unidade.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return unidade.get();
	}

}
