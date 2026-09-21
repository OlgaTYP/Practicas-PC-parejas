package com.example.todo.repository;

import com.example.todo.model.EstadoTarea;
import com.example.todo.model.Tarea;
import java.util.List;
import java.util.Optional;

public interface TareaRepository {

  Tarea guardar(Tarea tarea);

  Optional<Tarea> buscarPorId(Long id);

  List<Tarea> buscarTodas();

  long contarPorEstado(EstadoTarea estado);

  void eliminarPorId(Long id);
}
