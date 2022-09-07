package com.sas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sas.entity.Pessoa;
import com.sas.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Pessoa> listarPessoas() {
			return pessoaRepository.findAll();
	}
	
	public Optional<Pessoa> buscarPorId(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public Pessoa atualizar(Long Id, Pessoa pessoaSalvar) {
		Pessoa pessoaVaiSerAtualizada = validarPessoaExiste(Id);
		BeanUtils.copyProperties(pessoaSalvar, pessoaVaiSerAtualizada, "id");
		return pessoaRepository.save(pessoaVaiSerAtualizada);
		
	}
	
	public void deletar(Long id) {
		pessoaRepository.deleteById(id);
	}

	private Pessoa validarPessoaExiste(Long id) {
		Optional<Pessoa> pessoa = buscarPorId(id);
		if(pessoa.isEmpty()) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoa.get();
		
	}
	

}

	