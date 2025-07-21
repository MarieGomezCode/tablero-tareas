package com.maria.tablero_tareas.model;


import ch.qos.logback.core.status.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table("tarea")
public class Tarea {
    @Id
    private Long id;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private LocalDateTime creado;
}
