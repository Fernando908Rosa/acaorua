package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.TipoDeAcao;
import com.sas.repository.TipoDeAcaoRepository;

@Service
public class TipoDeAcaoService {
	
	@Autowired
	private TipoDeAcaoRepository tipoDeAcaoRepository;
	
	public List<TipoDeAcao> ListarTipoDeAcao() {
		return tipoDeAcaoRepository.findAll();
	}
	
	public Optional<TipoDeAcao> buscarPorId(Long id) {
		return tipoDeAcaoRepository.findById(id);	
	}
	
	public TipoDeAcao salvar(TipoDeAcao tipoDeAcao) {
		return tipoDeAcaoRepository.save(tipoDeAcao);
	}
	
	public TipoDeAcao atualizar(Long Id, TipoDeAcao tipoDeAcaoSalvar) {
		TipoDeAcao tipoDeAcaoVaiSerAtualizado = validarTipoDeAcaoExiste(Id);
		BeanUtils.copyProperties(tipoDeAcaoSalvar, tipoDeAcaoVaiSerAtualizado, "id");
		return tipoDeAcaoRepository.save(tipoDeAcaoVaiSerAtualizado);
		
	}
	
	public void deletar(Long id) {
		tipoDeAcaoRepository.deleteById(id);
	}
	
	private TipoDeAcao validarTipoDeAcaoExiste(Long id) {
		Optional<TipoDeAcao> tipoDeAcao = buscarPorId(id);
		if(tipoDeAcao.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoDeAcao.get();
	}
}
