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

import com.sas.dto.UnidadeEspecificaDeAbordagemRequestDto;
import com.sas.dto.UnidadeEspecificaDeAbordagemResponseDto;
import com.sas.entity.UnidadeEspecificaDeAbordagem;
import com.sas.service.UnidadeEspecificaDeAbordagemService;

@RestController
@RequestMapping("/api/unidadeEspecificaDeAbordagem")
public class UnidadeEspecificaDeAbordagemController {
	
	@Autowired
	private UnidadeEspecificaDeAbordagemService unidadeEspecificaDeAbordagemService;

	@GetMapping("/unidadeEspecificaDeAbordagem")
	public List<UnidadeEspecificaDeAbordagemResponseDto> getUnidadeEspecificaDeAbordagem() {
		return unidadeEspecificaDeAbordagemService.ListarUnidadeEspecificadeAbordagem().stream()
				.map(unidadeEspecificaDeAbordagem -> UnidadeEspecificaDeAbordagemResponseDto.converterUnidadeEspecificaDeAbordagemParaUnidadeEspecificaDeAbordagemResponseDto(unidadeEspecificaDeAbordagem))
				.collect(Collectors.toList());
	}
	 
	@GetMapping("/unidadeEspecificaDeAbordagem/{id}")
	public ResponseEntity <UnidadeEspecificaDeAbordagemResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<UnidadeEspecificaDeAbordagem> unidadeEspecificadeabordagem = unidadeEspecificaDeAbordagemService.buscarPorId(id);
		return unidadeEspecificadeabordagem.isPresent()
				? ResponseEntity.ok(UnidadeEspecificaDeAbordagemResponseDto.converterUnidadeEspecificaDeAbordagemParaUnidadeEspecificaDeAbordagemResponseDto(unidadeEspecificadeabordagem.get()))
				: ResponseEntity.notFound().build();		
						
	}
	
	@PostMapping("/unidadeEspecificaDeAbordagem")
	public ResponseEntity<UnidadeEspecificaDeAbordagemResponseDto> salvar(@Valid @RequestBody UnidadeEspecificaDeAbordagemRequestDto unidadeEspecificaDeAbordagemDto) {
		UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagemSalva = unidadeEspecificaDeAbordagemService.salvar(unidadeEspecificaDeAbordagemDto.converterUnidadeEspecificaDeAbordagemRequestDtoParaEntidadeUnidadeEspecificaDeAbordagem());
		return ResponseEntity.status(HttpStatus.CREATED).body(UnidadeEspecificaDeAbordagemResponseDto.converterUnidadeEspecificaDeAbordagemParaUnidadeEspecificaDeAbordagemResponseDto(unidadeEspecificaDeAbordagemSalva));
	}
	
	@PutMapping("/unidadeEspecificaDeAbordagem/{id}")
	public ResponseEntity<UnidadeEspecificaDeAbordagemResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody UnidadeEspecificaDeAbordagemRequestDto unidadeEspecificaDeAbordagemDto) {
		UnidadeEspecificaDeAbordagem unidadeEspecificaDeAbordagemAtualizado = unidadeEspecificaDeAbordagemService.atualizar(id, unidadeEspecificaDeAbordagemDto.converterUnidadeEspecificaDeAbordagemRequestDtoParaEntidadeUnidadeEspecificaDeAbordagem());
		return ResponseEntity.ok(UnidadeEspecificaDeAbordagemResponseDto.converterUnidadeEspecificaDeAbordagemParaUnidadeEspecificaDeAbordagemResponseDto(unidadeEspecificaDeAbordagemAtualizado));
	}
	
	@DeleteMapping("unidadeEspecificadeabordagem/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		unidadeEspecificaDeAbordagemService.deletar(id);
	}
	
}
