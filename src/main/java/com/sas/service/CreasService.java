package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.Creas;
import com.sas.repository.CreasRepository;

@Service
public class CreasService {
	
	@Autowired
	private CreasRepository creasRepository;
	
	public List<Creas> listarCreas() {
		return creasRepository.findAll();
}

public Optional<Creas> buscarPorId(Long id) {
	return creasRepository.findById(id);
}

public Creas salvar(Creas creas) {
	return creasRepository.save(creas);
}

public Creas atualizar(Long Id, Creas creasSalvar) {
	Creas creasVaiSerAtualizado = validarCreasExiste(Id);
	BeanUtils.copyProperties(creasSalvar, creasVaiSerAtualizado, "id");
	return creasRepository.save(creasVaiSerAtualizado);
	
}

public void deletar(Long id) {
	creasRepository.deleteById(id);
}

private Creas validarCreasExiste(Long id) {
	Optional<Creas> creas = buscarPorId(id);
	if(creas.isEmpty()) {
		throw new EmptyResultDataAccessException(1);
	}
	return creas.get();
	
	}

}
