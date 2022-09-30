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

import com.sas.dto.TipoDeAcaoRequestDto;
import com.sas.dto.TipoDeAcaoResponseDto;
import com.sas.entity.TipoDeAcao;
import com.sas.service.TipoDeAcaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "TipoDeAcao")
@RequestMapping("/api")
@RestController
public class TipoDeAcaoController {
	
	@Autowired
	TipoDeAcaoService tipoDeAcaoService;
	
	@ApiOperation(value = "Listar", nickname = "listarTodos")
	@GetMapping("/tipoDeAcao")
	public List<TipoDeAcaoResponseDto> getTipoDeAcao() {
		return tipoDeAcaoService.ListarTipoDeAcao().stream()
				.map(tipoDeAcao -> TipoDeAcaoResponseDto.converterTipoDeAcaoParaTipoDeAcaoResponseDto(tipoDeAcao))
                .collect(Collectors.toList());			
	}
	
	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping(("/tipoDeAcao{id}"))
	public ResponseEntity <TipoDeAcaoResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<TipoDeAcao> tipoDeacao = tipoDeAcaoService.buscarPorId(id);
		return tipoDeacao.isPresent()
				? ResponseEntity.ok(TipoDeAcaoResponseDto.converterTipoDeAcaoParaTipoDeAcaoResponseDto(tipoDeacao.get()))
				: ResponseEntity.notFound().build();	
	}
	
	@ApiOperation(value = "Salvar", nickname = "salvarTipoDeAcao")
	@PostMapping("/tipoDeAcao")
	public ResponseEntity<TipoDeAcaoResponseDto> salvar(@Valid @RequestBody TipoDeAcaoRequestDto tipoDeAcaoDto) {
		TipoDeAcao tipoDeAcaoSalva = tipoDeAcaoService.salvar(tipoDeAcaoDto.converterTipoDeAcaoRequestDtoParaEntidadeTipoDeAcao());
		return ResponseEntity.status(HttpStatus.CREATED).body(TipoDeAcaoResponseDto.converterTipoDeAcaoParaTipoDeAcaoResponseDto(tipoDeAcaoSalva));
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarTipoDeAcao")
	@PutMapping("/tipoDeAcao/{id}")
	public ResponseEntity<TipoDeAcaoResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody TipoDeAcaoRequestDto tipoDeAcaoDto) {
		TipoDeAcao tipoDeAcaoAtualizado = tipoDeAcaoService.atualizar(id, tipoDeAcaoDto.converterTipoDeAcaoRequestDtoParaEntidadeTipoDeAcao());
		return ResponseEntity.ok(TipoDeAcaoResponseDto.converterTipoDeAcaoParaTipoDeAcaoResponseDto(tipoDeAcaoAtualizado));
	}
	
	@ApiOperation(value = "Deletar", nickname = "deletarTipoDeAcao")
	@DeleteMapping("/tipoDeAcao/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		tipoDeAcaoService.deletar(id);
	}

}
