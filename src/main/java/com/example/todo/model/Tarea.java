package com.example.todo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Tarea {

    private Long id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private EstadoTarea estado;
    private LocalDate fechaLimite;
    private final LocalDateTime fechaCreacion;
    private LocalDateTime fechaCompletada;

    public Tarea(String titulo, String descripcion, Prioridad prioridad,
                 LocalDate fechaLimite, LocalDateTime fechaCreacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
        this.fechaCreacion = fechaCreacion;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public void actualizarDatos(String titulo, String descripcion, Prioridad prioridad, LocalDate fechaLimite) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaLimite = fechaLimite;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public Prioridad getPrioridad() { return prioridad; }
    public EstadoTarea getEstado() { return estado; }
    public void setEstado(EstadoTarea estado) { this.estado = estado; }
    public LocalDate getFechaLimite() { return fechaLimite; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public LocalDateTime getFechaCompletada() { return fechaCompletada; }
    public void setFechaCompletada(LocalDateTime fechaCompletada) { this.fechaCompletada = fechaCompletada; }
}
