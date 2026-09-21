package com.example.todo.exception;

public class TareaNoEncontradaException extends RuntimeException {

  public TareaNoEncontradaException(Long id) {
    super("No existe ninguna tarea con id " + id);
  }
}
