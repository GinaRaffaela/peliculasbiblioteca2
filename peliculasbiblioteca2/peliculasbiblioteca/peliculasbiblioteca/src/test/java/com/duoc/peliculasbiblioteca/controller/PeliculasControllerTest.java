package com.duoc.peliculasbiblioteca.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.duoc.peliculasbiblioteca.PeliculasController;
import com.duoc.peliculasbiblioteca.model.Pelicula;
import com.duoc.peliculasbiblioteca.service.impl.PeliculasServiceImpl;

@WebMvcTest(PeliculasController.class)
public class PeliculasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeliculasServiceImpl peliculasService;

    @Test
    public void obtenerPeliculas() throws Exception {
        //Arrange
        //Creacion de peliculas de prueba
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Pelicula de prueba");
        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Pelicula de prueba 2");
        List<Pelicula> peliculas = Arrays.asList(pelicula, pelicula2);
        when(peliculasService.getAllPeliculas()).thenReturn(peliculas);
        //Act y Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/peliculas"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculas[0].titulo", Matchers.is("Pelicula de prueba")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.peliculas[1].titulo", Matchers.is("Pelicula de prueba 2")));
    }
    
}
