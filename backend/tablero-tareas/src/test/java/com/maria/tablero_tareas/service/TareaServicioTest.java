package com.maria.tablero_tareas.service;

import com.maria.tablero_tareas.model.Estado;

import com.maria.tablero_tareas.model.Tarea;
import com.maria.tablero_tareas.repository.TareaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

public class TareaServicioTest {

    private TareaRepositorio repositorio;
    private TareaServicio servicio;

    @BeforeEach
    void setUp() {
        repositorio = mock(TareaRepositorio.class);
        servicio = new TareaServicio(repositorio);
    }

    @Test
    void testObtenerTodas() {
        Tarea tarea = new Tarea();
        tarea.setId(1L);
        tarea.setTitulo("Prueba");
        tarea.setEstado(Estado.POR_HACER);

        when(repositorio.findAll()).thenReturn(Flux.just(tarea));

        StepVerifier.create(servicio.obtenerTodas())
                .expectNext(tarea)
                .verifyComplete();
    }

    @Test
    void testCrearTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo("Crear tarea");
        tarea.setEstado(Estado.POR_HACER);

        when(repositorio.save(tarea)).thenReturn(Mono.just(tarea));

        StepVerifier.create(servicio.crear(tarea))
                .expectNext(tarea)
                .verifyComplete();
    }
}