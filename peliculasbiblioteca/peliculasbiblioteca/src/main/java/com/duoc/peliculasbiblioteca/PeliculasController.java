package com.duoc.peliculasbiblioteca;

import org.springframework.web.bind.annotation.RestController;

import com.duoc.peliculasbiblioteca.service.PeliculasService;
import com.duoc.peliculasbiblioteca.model.Pelicula;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    //Metodo para obtencion de lista completa de peliculas
    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculasService.getAllPeliculas();
    }
    
    //Metodo de obtencion de pelicula segun el id entregado
    @GetMapping("/peliculas/{id}")
    public Optional<Pelicula> getPeliculasById(@PathVariable Long id) throws Exception {
        return peliculasService.getPeliculaById(id);
    }
}
