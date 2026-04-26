package com.duoc.peliculasbiblioteca.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.peliculasbiblioteca.model.Pelicula;
import com.duoc.peliculasbiblioteca.repository.PeliculasRepository;
import com.duoc.peliculasbiblioteca.service.PeliculasService;

@Service
public class PeliculasServiceImpl implements PeliculasService {
    
    @Autowired
    private PeliculasRepository peliculasRepository;

    @Override
    public List<Pelicula> getAllPeliculas() {
        return peliculasRepository.findAll();
    }

    @Override
    public Optional<Pelicula> getPeliculaById(Long id) {
        return peliculasRepository.findById(id);
    }

    @Override
    public Pelicula createPelicula(Pelicula pelicula) {
        // TODO Auto-generated method stub
        return peliculasRepository.save(pelicula);
    }
}
