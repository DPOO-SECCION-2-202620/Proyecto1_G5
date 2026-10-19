package club.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import club.deportes.DeporteIndividual;
import club.deportes.Modalidad;

public class PruebaDeportesIndividuales {
    @Test void deporteIndividualConservaSuNombre() {
        DeporteIndividual tenis = new DeporteIndividual("Tenis", List.of(Modalidad.SOLOS)) { };
        assertEquals("Tenis", tenis.getNombre());
    }

    @Disabled("No existen InscripcionAcademia ni Nivel")
    @Test void inscripcionIniciaConNivelPrincipianteYEloCero() {
        // PENDIENTE: implementar inscripción de academia, nivel y ELO.
    }
    @Disabled("No existe la clase PartidoPractica")
    @Test void permiteParticipantesDeNivelesAdyacentes() {
        // PENDIENTE: implementar compatibilidad de niveles en partidos de práctica.
    }
    @Disabled("No existe la clase PartidoPractica")
    @Test void rechazaPrincipianteContraAvanzado() {
        // PENDIENTE: implementar el rechazo por diferencia de nivel.
    }
    @Disabled("No existen entrenadores ni partidos de práctica")
    @Test void permiteExcepcionDeEntrenadorJugador() {
        // PENDIENTE: implementar la excepción del entrenador jugador.
    }
    @Disabled("No existe ELO ni finalización de partidos")
    @Test void actualizaEloUnaSolaVezAlFinalizarPartido() {
        // PENDIENTE: implementar la actualización de ELO.
    }
}
