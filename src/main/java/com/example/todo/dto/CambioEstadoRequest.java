package com.example.todo.dto;

import com.example.todo.model.EstadoTarea;

import jakarta.validation.constraints.NotNull;

public record CambioEstadoRequest(
        @NotNull(message = "El estado es obligatorio")
        EstadoTarea estado) {
}
