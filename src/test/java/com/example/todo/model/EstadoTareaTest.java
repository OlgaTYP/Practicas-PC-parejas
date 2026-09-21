package com.example.todo.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EstadoTareaTest {

    @ParameterizedTest(name = "{0} -> {1} permitido: {2}")
    @CsvSource({
            "PENDIENTE,   PENDIENTE,   false",
            "PENDIENTE,   EN_PROGRESO, true",
            "PENDIENTE,   COMPLETADA,  false",
            "EN_PROGRESO, PENDIENTE,   true",
            "EN_PROGRESO, EN_PROGRESO, false",
            "EN_PROGRESO, COMPLETADA,  true",
            "COMPLETADA,  PENDIENTE,   false",
            "COMPLETADA,  EN_PROGRESO, false",
            "COMPLETADA,  COMPLETADA,  false"
    })
    void transicionesPermitidas(EstadoTarea origen, EstadoTarea destino, boolean esperado) {
        assertThat(origen.puedeTransitarA(destino)).isEqualTo(esperado);
    }
}
