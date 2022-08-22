package com.api.rest.repositories;

import com.api.rest.entities.Biblioteca;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {

}
