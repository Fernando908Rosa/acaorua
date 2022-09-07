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

import com.sas.dto.CreasResponseDto;
import com.sas.dto.CreasRequestDto;
import com.sas.entity.Creas;
import com.sas.service.CreasService;

@RequestMapping("/api")
@RestController
public class CreasController {
	
	@Autowired
	private CreasService creasService;
	
	@GetMapping("/creas")
	public List<CreasResponseDto> getCreas() {
		return creasService.listarCreas().stream()
				.map(creas -> CreasResponseDto.converterCreasParaCreasResponseDto(creas))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/creas/{id}")
	public ResponseEntity <CreasResponseDto> buscarPorId(@PathVariable Long id) {
		Optional<Creas> creas = creasService.buscarPorId(id);
		return creas.isPresent()
				? ResponseEntity.ok(CreasResponseDto.converterCreasParaCreasResponseDto(creas.get())) 
				: ResponseEntity.notFound().build();
	}
     
	@PostMapping("/creas")
	public ResponseEntity<CreasResponseDto> salvar(@Valid @RequestBody CreasRequestDto creasDto) {
		Creas creasSalva = creasService.salvar(creasDto.converterCreasRequestDtoParaEntidadeCreas());
		return ResponseEntity.status(HttpStatus.CREATED).body(CreasResponseDto.converterCreasParaCreasResponseDto(creasSalva));
	}
    
    @PutMapping("/creas/{id}")
    public ResponseEntity<CreasResponseDto> atualizar(@PathVariable Long id, @Valid @RequestBody CreasRequestDto creasDto) {
    	Creas creasAtualizado = creasService.atualizar(id, creasDto.converterCreasRequestDtoParaEntidadeCreas());
        return ResponseEntity.ok(CreasResponseDto.converterCreasParaCreasResponseDto(creasAtualizado));
    	
	}
	
	@DeleteMapping("/creas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id) {
    	creasService.deletar(id);
    }	

}
