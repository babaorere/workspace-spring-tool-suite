package com.api.rest.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.api.rest.entities.Biblioteca;
import com.api.rest.entities.Libro;
import com.api.rest.repositories.BibliotecaRepository;
import com.api.rest.repositories.LibroRepository;
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
@RequestMapping(path = "/api/libro", produces = "application/json")
public class LibroController {

	@Autowired
	private BibliotecaRepository biblioRepo;

	@Autowired
	private LibroRepository libroRepo;

	@GetMapping
	private ResponseEntity<Page<Libro>> obtenerTodo(Pageable pageable) {

		return ResponseEntity.ok(libroRepo.findAll(pageable));
	}

	@PostMapping
	private ResponseEntity<Libro> guardar(@Valid @RequestBody Libro item) {

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(item.getBiblioteca().getBibliotecaId());

		// Verificar si tiene una biblioteca guardada,
		// de lo contrario podria ser un registro huerfano
		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		item.setBiblioteca(biblioOpt.get());
		Libro itemSaved = libroRepo.save(item);
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(itemSaved.getLibroId()).toUri();

		return ResponseEntity.created(ubicacion).body(itemSaved);
	}

	@PutMapping("/{id}")
	private ResponseEntity<Libro> actualizar(@PathVariable Long id, @Valid @RequestBody Libro item) {

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(item.getBiblioteca().getBibliotecaId());
		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Optional<Libro> libroOpt = libroRepo.findById(id);
		if (!libroOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Biblioteca biblio = biblioOpt.get();
		Libro libroOld = libroOpt.get();

		item.setBiblioteca(biblio);
		item.setLibroId(libroOld.getLibroId());
		item.setLockFlag(libroOld.getLockFlag());

		libroRepo.save(item);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/{id}")
	private ResponseEntity<Libro> eliminar(@PathVariable Long id) {

		Optional<Libro> libroOpt = libroRepo.findById(id);

		if (!libroOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		libroRepo.delete(libroOpt.get());

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	private ResponseEntity<Libro> obtener(@PathVariable Long id) {

		Optional<Libro> libroOpt = libroRepo.findById(id);
		if (!libroOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Libro libro = libroOpt.get();

		Optional<Biblioteca> biblioOpt = biblioRepo.findById(libro.getBiblioteca().getBibliotecaId());
		if (!biblioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

//		libro.setBiblioteca(biblioOpt.get());

		return ResponseEntity.ok(libro);
	}

}
