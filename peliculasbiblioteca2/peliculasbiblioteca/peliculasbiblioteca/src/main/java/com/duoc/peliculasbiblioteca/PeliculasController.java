package com.duoc.peliculasbiblioteca;

import org.springframework.web.bind.annotation.RestController;

import com.duoc.peliculasbiblioteca.service.PeliculasService;
import com.duoc.peliculasbiblioteca.exception.PeliculasNotFoundException;
import com.duoc.peliculasbiblioteca.model.Pelicula;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    //Metodo para agregar peliculas nuevas
    @PostMapping("/peliculas")
    public EntityModel<Pelicula> addPelicula(@RequestBody Pelicula entity) {
        Pelicula pelicula = peliculasService.createPelicula(entity);
        return EntityModel.of(pelicula,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculasById(pelicula.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculas()).withRel("peliculas"));
    }

    //Metodo para obtencion de lista completa de peliculas
    @GetMapping("/peliculas")
    public CollectionModel<EntityModel<Pelicula>> getPeliculas() {
        List<Pelicula> peliculas = peliculasService.getAllPeliculas();

        List<EntityModel<Pelicula>> peliculasModel = peliculas.stream()
                .map(pelicula -> EntityModel.of(pelicula,
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculasById(pelicula.getId())).withSelfRel()
                    ))
                .collect(Collectors.toList());

        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculas());
        CollectionModel<EntityModel<Pelicula>> result = CollectionModel.of(peliculasModel, link.withRel("peliculas"));

        return result;
    }
    
    //Metodo de obtencion de pelicula segun el id entregado
    @GetMapping("/peliculas/{id}")
    public EntityModel<Pelicula> getPeliculasById(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculasService.getPeliculaById(id);

        if (pelicula.isPresent()) {
            return EntityModel.of(pelicula.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculasById(pelicula.get().getId())).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(PeliculasController.class).getPeliculas()).withRel("peliculas"));
        } else {
            throw new PeliculasNotFoundException("Pelicula no encontrada con id: " + id);
        }
    }
}
