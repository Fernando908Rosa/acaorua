package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.CadastramentoDoAcompanhamento;
import com.sas.repository.CadastramentoDoAcompanhamentoRepository;

@Service
public class CadastramentoDoAcompanhamentoService {
	
	@Autowired
	private CadastramentoDoAcompanhamentoRepository cadastramentoDoAcompanhamentoRepository;
	
	public List<CadastramentoDoAcompanhamento> ListarCadastramentoDoAcompanhamento() {
		return cadastramentoDoAcompanhamentoRepository.findAll();	
	}
	
	public Optional<CadastramentoDoAcompanhamento> buscarPorId(Long id) {
		return cadastramentoDoAcompanhamentoRepository.findById(id);	
	}
	
	public CadastramentoDoAcompanhamento salvar(CadastramentoDoAcompanhamento cadastramentoDoAcompanhamento) {
		return cadastramentoDoAcompanhamentoRepository.save(cadastramentoDoAcompanhamento);
	}
	
	public CadastramentoDoAcompanhamento atualizar(Long Id, CadastramentoDoAcompanhamento cadastramentoDoAcompanhamentoSalvar) {
		CadastramentoDoAcompanhamento cadastramentoDoAcompanhamentoAtualizado = validarCadastramentoDoAcompanhamentoExiste(Id);
		BeanUtils.copyProperties(cadastramentoDoAcompanhamentoSalvar, cadastramentoDoAcompanhamentoAtualizado, "id");
		return cadastramentoDoAcompanhamentoRepository.save(cadastramentoDoAcompanhamentoAtualizado);
	}
	
	public void deletar(Long id) {
		cadastramentoDoAcompanhamentoRepository.deleteById(id);
	}
	
	private CadastramentoDoAcompanhamento validarCadastramentoDoAcompanhamentoExiste(Long id) {
		Optional<CadastramentoDoAcompanhamento> cadastramentoDoAcompanhamento = buscarPorId(id);
		if(cadastramentoDoAcompanhamento.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return cadastramentoDoAcompanhamento.get();
	}

}
