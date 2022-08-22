package com.api.rest.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.api.rest.entities.Biblioteca;
import com.api.rest.repositories.BibliotecaRepository;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaRepository biblioRepo;

	@PostMapping
	private ResponseEntity<Biblioteca> guardar(@Valid @RequestBody Biblioteca biblio) {
		Biblioteca itemSaved = biblioRepo.save(biblio);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(itemSaved.getBibliotecaId()).toUri();

		return ResponseEntity.created(ubicacion).body(itemSaved);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Biblioteca> actualizar(@PathVariable Long id, @Valid @RequestBody Biblioteca biblio) {

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(id);

		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Biblioteca biblioOld = biblioOpt.get();

		biblio.setBibliotecaId(biblioOld.getBibliotecaId());
		biblio.setLockFlag(biblioOld.getLockFlag());

		biblioRepo.save(biblio);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Biblioteca> eliminar(@PathVariable Long id) {

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(id);

		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		biblioRepo.delete(biblioOpt.get());

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	private ResponseEntity<Biblioteca> obtener(@PathVariable Long id) {

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(id);

		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(biblioOpt.get());
	}

	@GetMapping
	private ResponseEntity<Page<Biblioteca>> obtenerTodo(Pageable pageable) {

		return ResponseEntity.ok(biblioRepo.findAll(pageable));
	}

}
