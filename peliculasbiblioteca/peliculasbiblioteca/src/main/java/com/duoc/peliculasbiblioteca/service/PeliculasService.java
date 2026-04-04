package com.duoc.peliculasbiblioteca.service;

import java.util.List;
import java.util.Optional;

import com.duoc.peliculasbiblioteca.model.Pelicula;

public interface PeliculasService {
    List<Pelicula> getAllPeliculas();
    Optional<Pelicula> getPeliculaById(Long id);
}
