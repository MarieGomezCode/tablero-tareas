package com.maria.tablero_tareas.controller;


import com.maria.tablero_tareas.model.Tarea;
import com.maria.tablero_tareas.service.TareaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class TareaControlador {
    private final TareaServicio servicio;
    @GetMapping
    public Flux<Tarea> obtenerTodas(){
        return servicio.obtenerTodas();
    }
    @GetMapping("/{id}")
    public Mono<Tarea> obtenerPorId(@PathVariable Long id){
        return servicio.obtenerPorId(id);
    }
    @PostMapping
    public Mono<Tarea> crear(@RequestBody Tarea tarea){
        return servicio.crear(tarea);
    }
    @DeleteMapping("/{id}")
    public Mono<Void> eliminar(@PathVariable Long id){
        return  servicio.eliminar(id);
    }


}
