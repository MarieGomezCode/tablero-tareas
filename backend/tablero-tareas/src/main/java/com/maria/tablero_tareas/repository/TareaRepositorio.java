package com.maria.tablero_tareas.repository;

import com.maria.tablero_tareas.model.Tarea;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TareaRepositorio extends ReactiveCrudRepository<Tarea, Long> {
}
