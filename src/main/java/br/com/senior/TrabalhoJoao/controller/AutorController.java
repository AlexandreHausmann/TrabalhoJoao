package br.com.senior.TrabalhoJoao.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.senior.TrabalhoJoao.dto.AutorDto;
import br.com.senior.TrabalhoJoao.mapper.AutorMapper;
import model.entity.Autor;
import model.exception.AutorNotFoundExcption;
import model.service.AutorService;

@Controller
@RestController
@RequestMapping(path = "/autor")
public class AutorController {
	@Autowired
	private AutorService service;
	@Autowired
	private AutorMapper mapper;

	@PostMapping(path = "/api/Autor")
	public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody AutorDto autorDto) {
		Autor autor = mapper.toEntity(autorDto);
		AutorDto body = mapper.toDto(service.saveAutor(autor));
		return ResponseEntity.ok().body(body);
	}

	@PutMapping(path = "/api/autor/{idAutor}")
	public ResponseEntity<AutorDto> atualizarAtor(@PathVariable String idAutor, @RequestBody AutorDto autorDto) {
		UUID id = UUID.fromString(idAutor);
		Autor autor = mapper.toEntity(autorDto);
		AutorDto body = mapper.toDto(service.updateautor(id, autor));
		if (Objects.isNull(body)) {
			throw new AutorNotFoundExcption("Autor não pode ser vazio");
		}
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "api/autor/{idAutor}")
	public ResponseEntity<AutorDto> findById(@PathVariable String idAutor) {
		UUID id = UUID.fromString(idAutor);
		AutorDto body = mapper.toDto(service.getAutor(id));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "api/autor")
	public ResponseEntity<List<AutorDto>> findAll() {
		List<AutorDto> autorDtos = service.getAllAutor().stream().map(e -> mapper.toDto(e))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(autorDtos);
	}

	@DeleteMapping(path = "api/deletarAutor/{idAutor}")
	public ResponseEntity<Void> delete(@PathVariable String idAutor) {
		UUID id = UUID.fromString(idAutor);
		service.deleteAutor(id);
		return ResponseEntity.ok().build();
	}
}