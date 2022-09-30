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

import com.sas.dto.AcompanhamentoRequestDto;
import com.sas.dto.AcompanhamentoResponseDto;
import com.sas.entity.Acompanhamento;
import com.sas.service.AcompanhamentoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Acompanhamento")
@RequestMapping("/api")
@RestController
public class AcompanhamentoController {
	
	@Autowired
	private AcompanhamentoService acompanhamentoService;
	
	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/acompanhamento")
	public List<AcompanhamentoResponseDto> getAcompanhamento() {
		return acompanhamentoService.ListarAcompanhamento().stream()
				.map(Acompanhamento -> AcompanhamentoResponseDto.converterAcompanhamentoParaAcompanhamentotoResponseDto(Acompanhamento))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/acompanhamento/{id}")
	public ResponseEntity <AcompanhamentoResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Acompanhamento> acompanhamento = acompanhamentoService.buscarPorId(id);
		return acompanhamento.isPresent()
			? ResponseEntity.ok(AcompanhamentoResponseDto.converterAcompanhamentoParaAcompanhamentotoResponseDto(acompanhamento.get()))
			: ResponseEntity.notFound().build();		
	}
	
	@ApiOperation(value = "Salvar", nickname = "salvarAcompanhamento")
	@PostMapping("/acompanhamento/{idCreas}/{idUnidade}/{idTipoDeAcao}/{idPessoa}/{idUsuario}")
	public ResponseEntity<AcompanhamentoResponseDto> salvar(@PathVariable Long idCreas, @PathVariable Long idUnidade, @PathVariable Long idTipoDeAcao, @PathVariable Long idPessoa, @PathVariable Long idUsuario, @Valid @RequestBody AcompanhamentoRequestDto AcompanhamentoDto) {
		Acompanhamento AcompanhamentoSalva = acompanhamentoService.salvar(AcompanhamentoDto.converterAcompanhamentoRequestDtoParaEntidadeAcompanhamento(idCreas, idUnidade, idTipoDeAcao, idPessoa, idUsuario));
		return ResponseEntity.status(HttpStatus.CREATED).body(AcompanhamentoResponseDto.converterAcompanhamentoParaAcompanhamentotoResponseDto(AcompanhamentoSalva));
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarAcompanhamento")
	@PutMapping("/acompanhamento/{id}")
	public ResponseEntity<AcompanhamentoResponseDto> atualizar(@PathVariable Long id, @PathVariable Long idCreas, @PathVariable Long idUnidade, @PathVariable Long idTipoDeAcao, @PathVariable Long idPessoa, @PathVariable Long idUsuario, @Valid @RequestBody AcompanhamentoRequestDto acompanhamentoDto) {
		Acompanhamento Acompanhamentoatualizado = acompanhamentoService.atualizar(id, acompanhamentoDto.converterAcompanhamentoRequestDtoParaEntidadeAcompanhamento(idCreas, idUnidade, idTipoDeAcao, idPessoa, idUsuario));
		return ResponseEntity.ok(AcompanhamentoResponseDto.converterAcompanhamentoParaAcompanhamentotoResponseDto(Acompanhamentoatualizado));
	}
	
	@ApiOperation(value = "Deletar", nickname = "deletarAcompanhamento")
	@DeleteMapping("/acompanhamento/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		acompanhamentoService.deletar(id);
	}
	
}
