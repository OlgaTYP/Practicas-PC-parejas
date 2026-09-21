package com.example.todo.exception;

/** Se lanza cuando una operación viola una regla de negocio. */
public class ReglaNegocioException extends RuntimeException {

    public ReglaNegocioException(String mensaje) {
        super(mensaje);
    }
}
