package com.example.todo.dto;

import com.example.todo.model.Prioridad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/** Datos para crear o actualizar una tarea. */
public record TareaRequest(
    @NotBlank(message = "El título es obligatorio")
        @Size(min = 3, max = 100, message = "El título debe tener entre 3 y 100 caracteres")
        String titulo,
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
        String descripcion,
    @NotNull(message = "La prioridad es obligatoria") Prioridad prioridad,
    LocalDate fechaLimite) {}
