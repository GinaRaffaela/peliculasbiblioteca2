package com.duoc.peliculasbiblioteca.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.duoc.peliculasbiblioteca.model.Pelicula;
import com.duoc.peliculasbiblioteca.repository.PeliculasRepository;
import com.duoc.peliculasbiblioteca.service.impl.PeliculasServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PeliculaServiceTest {

    @InjectMocks
    private PeliculasServiceImpl peliculaService;

    @Mock
    private PeliculasRepository peliculasRepository;

    @Test
    void createPelicula() {
        //Arrange
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Pelicula de prueba");

        when(peliculasRepository.save(any())).thenReturn(pelicula);
        //Act
        Pelicula resultado = peliculaService.createPelicula(pelicula);
        //Assert
        assertEquals("Pelicula de prueba", resultado.getTitulo());
    }
}
