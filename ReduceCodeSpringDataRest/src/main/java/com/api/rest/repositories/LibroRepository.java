package com.api.rest.repositories;

import com.api.rest.entities.Libro;

import org.springframework.data.repository.CrudRepository;

public interface LibroRepository extends CrudRepository<Libro, Long> {

}
