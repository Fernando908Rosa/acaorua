package com.sas.controller;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sas.dto.PessoaRequestDto;
import com.sas.dto.PessoaResponseDto;
import com.sas.entity.Pessoa;
import com.sas.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Pessoas")
@RequestMapping("/api")
@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;
    
	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/pessoas")
	public List<PessoaResponseDto> getPessoa() {
		return pessoaService.listarPessoas().stream()
				.map(pessoa -> PessoaResponseDto.converterPessoaParaPessoaResponseDto(pessoa))
				.collect(Collectors.toList());
	}
    
	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<PessoaResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Pessoa> pessoa = pessoaService.buscarPorId(id);
		return pessoa.isPresent()
				? ResponseEntity.ok(PessoaResponseDto.converterPessoaParaPessoaResponseDto(pessoa.get()))
				: ResponseEntity.notFound().build();
	}
    
	@ApiOperation(value = "Salvar", nickname = "salvarPessoas")
	@PostMapping("/pessoa")
	public ResponseEntity<PessoaResponseDto> salvar(@Valid @RequestBody PessoaRequestDto pessoaDto) {
		Pessoa pessoaSalva = pessoaService.salvar(pessoaDto.converterPessoaRequestDtoParaEntidadePessoa());
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(PessoaResponseDto.converterPessoaParaPessoaResponseDto(pessoaSalva));
	}
    
	@ApiOperation(value = "Atualizar", nickname = "atualizarPessoas")
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<PessoaResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody PessoaRequestDto pessoaDto) {
		Pessoa pessoaAtualizada = pessoaService.atualizar(id, pessoaDto.converterPessoaRequestDtoParaEntidadePessoa());
		return ResponseEntity.ok(PessoaResponseDto.converterPessoaParaPessoaResponseDto(pessoaAtualizada));

	}
    
	@ApiOperation(value = "Deletar", nickname = "deletarPessoas")

	@DeleteMapping("/pessoa/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		pessoaService.deletar(id);
	}

}
