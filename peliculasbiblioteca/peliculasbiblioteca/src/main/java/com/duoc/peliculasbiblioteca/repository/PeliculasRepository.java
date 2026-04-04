package com.duoc.peliculasbiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.duoc.peliculasbiblioteca.model.Pelicula;

public interface PeliculasRepository extends JpaRepository<Pelicula, Long> {
    
}
