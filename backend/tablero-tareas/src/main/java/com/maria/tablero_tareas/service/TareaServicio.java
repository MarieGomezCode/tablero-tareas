package com.maria.tablero_tareas.service;


import com.maria.tablero_tareas.model.Tarea;
import com.maria.tablero_tareas.repository.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TareaServicio {
    private final TareaRepositorio repositorio;

    public Flux<Tarea> obtenerTodas(){
        return repositorio.findAll();
    }

    public Mono<Tarea> obtenerPorId(long id){
        return repositorio.findById(id);
    }

    public Mono<Tarea> crear(Tarea tarea){
        return repositorio.save(tarea);
    }

    public Mono<Void> eliminar(Long id){
        return repositorio.deleteById(id);
    }

}
