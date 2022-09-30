package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.Acompanhamento;
import com.sas.repository.AcompanhamentoRepository;

@Service
public class AcompanhamentoService {
	
	@Autowired
	private AcompanhamentoRepository AcompanhamentoRepository;
	
	public List<Acompanhamento> ListarAcompanhamento() {
		return AcompanhamentoRepository.findAll();	
	}
	
	public Optional<Acompanhamento> buscarPorId(Long id) {
		return AcompanhamentoRepository.findById(id);	
	}
	
	public Acompanhamento salvar(Acompanhamento acompanhamento) {
		return AcompanhamentoRepository.save(acompanhamento);
	}
	
	public Acompanhamento atualizar(Long Id, Acompanhamento AcompanhamentoSalvar) {
		Acompanhamento AcompanhamentoAtualizado = validarAcompanhamentoExiste(Id);
		BeanUtils.copyProperties(AcompanhamentoSalvar, AcompanhamentoAtualizado, "id");
		return AcompanhamentoRepository.save(AcompanhamentoAtualizado);
	}
	

	public void deletar(Long id) {
		AcompanhamentoRepository.deleteById(id);
	}
	
	private Acompanhamento validarAcompanhamentoExiste(Long id) {
		Optional<Acompanhamento> Acompanhamento = buscarPorId(id);
		if(Acompanhamento.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return Acompanhamento.get();
	}

}
