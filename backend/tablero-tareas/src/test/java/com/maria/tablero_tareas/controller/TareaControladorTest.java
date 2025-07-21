package com.maria.tablero_tareas.controller;


import com.maria.tablero_tareas.model.Estado;
import com.maria.tablero_tareas.model.Tarea;
import com.maria.tablero_tareas.service.TareaServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import static org.mockito.Mockito.when;

@WebFluxTest(TareaControlador.class)
public class TareaControladorTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private TareaServicio tareaServicio;

    @Test
    void testObtenerTareas() {
        Tarea tarea = new Tarea();
        tarea.setId(1L);
        tarea.setTitulo("Mock Tarea");
        tarea.setEstado(Estado.POR_HACER);

        when(tareaServicio.obtenerTodas()).thenReturn(Flux.just(tarea));

        webTestClient.get()
                .uri("/tareas")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Tarea.class)
                .hasSize(1);
    }
}