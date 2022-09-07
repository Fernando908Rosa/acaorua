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

import com.sas.dto.CadastramentoDoAcompanhamentoRequestDto;
import com.sas.dto.CadastramentoDoAcompanhamentoResponseDto;
import com.sas.entity.CadastramentoDoAcompanhamento;
import com.sas.service.CadastramentoDoAcompanhamentoService;

@RequestMapping("/api")
@RestController
public class CadastramentoDoAcompanhamentoController {
	
	@Autowired
	private CadastramentoDoAcompanhamentoService cadastramentoDoAcompanhamentoService;
	
	@GetMapping("/cadastramentoDoAcompanhamento")
	public List<CadastramentoDoAcompanhamentoResponseDto> getCadastramentoDoAcompanhamento() {
		return cadastramentoDoAcompanhamentoService.ListarCadastramentoDoAcompanhamento().stream()
				.map(cadastramentoDoAcompanhamento -> CadastramentoDoAcompanhamentoResponseDto.converterCadastramentoDoAcompanhamentoParaCadastramentoDoAcompanhamentotoResponseDto(cadastramentoDoAcompanhamento))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/cadastramentoDoAcompanhamento/{id}")
	public ResponseEntity <CadastramentoDoAcompanhamentoResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<CadastramentoDoAcompanhamento> cadastramentoDoAcompanhamento = cadastramentoDoAcompanhamentoService.buscarPorId(id);
		return cadastramentoDoAcompanhamento.isPresent()
			? ResponseEntity.ok(CadastramentoDoAcompanhamentoResponseDto.converterCadastramentoDoAcompanhamentoParaCadastramentoDoAcompanhamentotoResponseDto(cadastramentoDoAcompanhamento.get()))
			: ResponseEntity.notFound().build();		
	}
	
	@PostMapping("/cadastramentoDoAcompanhamento")
	public ResponseEntity<CadastramentoDoAcompanhamentoResponseDto> salvar(@Valid @RequestBody CadastramentoDoAcompanhamentoRequestDto cadastramentoDoAcompanhamentoDto) {
		CadastramentoDoAcompanhamento cadastramentoDoAcompanhamentoSalva = cadastramentoDoAcompanhamentoService.salvar(cadastramentoDoAcompanhamentoDto.converterCadastramentoDoAcompanhamentoRequestDtoParaEntidadeCadastramentoDoAcompanhamento());
		return ResponseEntity.status(HttpStatus.CREATED).body(CadastramentoDoAcompanhamentoResponseDto.converterCadastramentoDoAcompanhamentoParaCadastramentoDoAcompanhamentotoResponseDto(cadastramentoDoAcompanhamentoSalva));
	}
	
	@PutMapping("/cadastramentoDoAcompanhamento/{id}")
	public ResponseEntity<CadastramentoDoAcompanhamentoResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody CadastramentoDoAcompanhamentoRequestDto cadastramentoDoAcompanhamentoDto) {
		CadastramentoDoAcompanhamento cadastramentoDoAcompanhamentoatualizado = cadastramentoDoAcompanhamentoService.atualizar(id, cadastramentoDoAcompanhamentoDto.converterCadastramentoDoAcompanhamentoRequestDtoParaEntidadeCadastramentoDoAcompanhamento());
		return ResponseEntity.ok(CadastramentoDoAcompanhamentoResponseDto.converterCadastramentoDoAcompanhamentoParaCadastramentoDoAcompanhamentotoResponseDto(cadastramentoDoAcompanhamentoatualizado));
	}
	
	@DeleteMapping("/cadastramentoDoAcompanhante/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		cadastramentoDoAcompanhamentoService.deletar(id);
	}
	
}
