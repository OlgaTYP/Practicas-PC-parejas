package com.example.todo.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.todo.model.Prioridad;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

/** Comprueba las validaciones de Bean Validation sin arrancar Spring. */
class TareaRequestValidacionTest {

    private static Validator validador;

    @BeforeAll
    static void crearValidador() {
        validador = Validation.buildDefaultValidatorFactory().getValidator();
    }

    private static List<String> camposInvalidos(TareaRequest peticion) {
        Set<ConstraintViolation<TareaRequest>> violaciones = validador.validate(peticion);
        return violaciones.stream().map(v -> v.getPropertyPath().toString()).sorted().toList();
    }

    @Test
    void peticionCorrecta_noTieneViolaciones() {
        TareaRequest ok = new TareaRequest("Estudiar", "Repasar capítulo 3", Prioridad.MEDIA, LocalDate.of(2030, 1, 1));

        assertThat(camposInvalidos(ok)).isEmpty();
    }

    @Test
    void tituloEnBlanco_esInvalido() {
        assertThat(camposInvalidos(new TareaRequest("   ", null, Prioridad.BAJA, null)))
                .contains("titulo");
    }

    @Test
    void tituloDemasiadoCorto_esInvalido() {
        assertThat(camposInvalidos(new TareaRequest("ab", null, Prioridad.BAJA, null)))
                .containsExactly("titulo");
    }

    @Test
    void tituloDemasiadoLargo_esInvalido() {
        String largo = "x".repeat(101);

        assertThat(camposInvalidos(new TareaRequest(largo, null, Prioridad.BAJA, null)))
                .containsExactly("titulo");
    }

    @Test
    void descripcionDeMasDe500Caracteres_esInvalida() {
        String larga = "x".repeat(501);

        assertThat(camposInvalidos(new TareaRequest("Título válido", larga, Prioridad.BAJA, null)))
                .containsExactly("descripcion");
    }

    @Test
    void prioridadNula_esInvalida() {
        assertThat(camposInvalidos(new TareaRequest("Título válido", null, null, null)))
                .containsExactly("prioridad");
    }
}
