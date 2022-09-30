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

import com.sas.dto.UnidadeRequestDto;
import com.sas.dto.UnidadeResponseDto;
import com.sas.entity.Unidade;
import com.sas.service.UnidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Unidade")
@RestController
@RequestMapping("/api/unidade")
public class UnidadeController {
	
	@Autowired
	private UnidadeService unidadeService;
	
	@ApiOperation(value = "Listar", nickname = "listarTodos")
  	@GetMapping("/unidade")
	public List<UnidadeResponseDto> getUnidade() {
		return unidadeService.ListarUnidade().stream()
				.map(unidade -> UnidadeResponseDto.converterUnidadeParaUnidadeResponseDto(unidade))
				.collect(Collectors.toList());
	}
	 
	@ApiOperation(value = "Buscar Por Id", nickname = "buscarPorId")
	@GetMapping("/unidade/{id}")
	public ResponseEntity <UnidadeResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Unidade> unidade = unidadeService.buscarPorId(id);
		return unidade.isPresent()
				? ResponseEntity.ok(UnidadeResponseDto.converterUnidadeParaUnidadeResponseDto(unidade.get()))
				: ResponseEntity.notFound().build();		
						
	}
	
	@ApiOperation(value = "Salvar", nickname = "salvarUnidade")
	@PostMapping("/unidade")
	public ResponseEntity<UnidadeResponseDto> salvar(@Valid @RequestBody UnidadeRequestDto unidadeDto) {
		Unidade unidadeSalva = unidadeService.salvar(unidadeDto.converterUnidadeRequestDtoParaEntidadeUnidade());
		return ResponseEntity.status(HttpStatus.CREATED).body(UnidadeResponseDto.converterUnidadeParaUnidadeResponseDto(unidadeSalva));
	}
	
	@ApiOperation(value = "Atualizar", nickname = "atualizarUnidade")
	@PutMapping("/unidade/{id}")
	public ResponseEntity<UnidadeResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody UnidadeRequestDto unidadeDto) {
		Unidade unidadeAtualizado = unidadeService.atualizar(id, unidadeDto.converterUnidadeRequestDtoParaEntidadeUnidade());
		return ResponseEntity.ok(UnidadeResponseDto.converterUnidadeParaUnidadeResponseDto(unidadeAtualizado));
	}
	
	@ApiOperation(value = "Deletar", nickname = "deletarUnidade")
	@DeleteMapping("unidade/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(Long id) {
		unidadeService.deletar(id);
	}
	
}
