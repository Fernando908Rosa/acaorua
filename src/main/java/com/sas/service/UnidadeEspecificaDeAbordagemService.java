package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.UnidadeEspecificaDeAbordagem;
import com.sas.repository.UnidadeEspecificaDeAbordagemRepository;

@Service
public class UnidadeEspecificaDeAbordagemService {
	
	@Autowired
	private UnidadeEspecificaDeAbordagemRepository unidadeEspecificaDeAbordagemRepository;
	
	public List<UnidadeEspecificaDeAbordagem> ListarUnidadeEspecificadeAbordagem() {
		return unidadeEspecificaDeAbordagemRepository.findAll();
	}
	
	public Optional<UnidadeEspecificaDeAbordagem> buscarPorId(Long id) {
		return unidadeEspecificaDeAbordagemRepository.findById(id);
	}
	
	public UnidadeEspecificaDeAbordagem salvar(UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagem) {
		return unidadeEspecificaDeAbordagemRepository.save(unidadeEspecificaDeAbordagem);
	}
	
	public UnidadeEspecificaDeAbordagem atualizar(Long id, UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagemSalvar) {
		UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagemVaiSerAtualizada = validarUnidadeEspecificaDeAbordagemExiste(id);
		BeanUtils.copyProperties(unidadeEspecificaDeAbordagemSalvar, unidadeEspecificaDeAbordagemVaiSerAtualizada, "id");
		return unidadeEspecificaDeAbordagemRepository.save(unidadeEspecificaDeAbordagemVaiSerAtualizada);
	}
	
	public void deletar(Long id) {
		unidadeEspecificaDeAbordagemRepository.deleteById(id);
	}
	
	private UnidadeEspecificaDeAbordagem validarUnidadeEspecificaDeAbordagemExiste(Long id) {
		Optional<UnidadeEspecificaDeAbordagem> unidadeEspecificaDeAbordagem = buscarPorId(id);
		if(unidadeEspecificaDeAbordagem.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return unidadeEspecificaDeAbordagem.get();
	}

}
