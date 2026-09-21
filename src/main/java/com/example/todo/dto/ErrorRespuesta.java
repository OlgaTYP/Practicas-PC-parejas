package com.example.todo.dto;

import java.time.LocalDateTime;
import java.util.List;

/** Cuerpo JSON uniforme para todos los errores de la API. */
public record ErrorRespuesta(
        LocalDateTime timestamp,
        int status,
        String error,
        String mensaje,
        List<String> detalles) {
}
