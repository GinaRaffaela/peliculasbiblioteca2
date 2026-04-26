package com.duoc.peliculasbiblioteca.repository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.duoc.peliculasbiblioteca.model.Pelicula;

import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculasRepositoryTest {

    @Autowired
    private PeliculasRepository peliculasRepository;

    @Test
    void createPelicula() {
        //Arrange
        Pelicula pelicula = new Pelicula();
        pelicula.setTitulo("Pelicula de prueba");
        //Act
        Pelicula resultado = peliculasRepository.save(pelicula);
        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Pelicula de prueba", resultado.getTitulo());
    }
}
