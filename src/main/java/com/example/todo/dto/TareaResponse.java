package com.example.todo.dto;

import com.example.todo.model.EstadoTarea;
import com.example.todo.model.Prioridad;
import com.example.todo.model.Tarea;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TareaResponse(
    Long id,
    String titulo,
    String descripcion,
    Prioridad prioridad,
    EstadoTarea estado,
    LocalDate fechaLimite,
    LocalDateTime fechaCreacion,
    LocalDateTime fechaCompletada) {

  public static TareaResponse desde(Tarea t) {
    return new TareaResponse(
        t.getId(),
        t.getTitulo(),
        t.getDescripcion(),
        t.getPrioridad(),
        t.getEstado(),
        t.getFechaLimite(),
        t.getFechaCreacion(),
        t.getFechaCompletada());
  }
}
