package com.example.todo.model;

/**
 * Estados posibles de una tarea y transiciones permitidas:
 * PENDIENTE -> EN_PROGRESO -> COMPLETADA (y EN_PROGRESO -> PENDIENTE).
 * Una tarea COMPLETADA es final.
 */
public enum EstadoTarea {
    PENDIENTE, EN_PROGRESO, COMPLETADA;

    public boolean puedeTransitarA(EstadoTarea destino) {
        return switch (this) {
            case PENDIENTE -> destino == EN_PROGRESO;
            case EN_PROGRESO -> destino == PENDIENTE || destino == COMPLETADA;
            case COMPLETADA -> false;
        };
    }
}
