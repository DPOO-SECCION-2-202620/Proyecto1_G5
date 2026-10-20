package club.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import club.Inscripciones.InscripcionAcademia;
import club.deportes.Deporte;
import club.deportes.Nivel;
import club.deportes.Modalidad;
import club.deportes.Tenis;
import club.partidos.PartidoPractica;
import club.personal.Entrenador;
import club.usuarios.Socio;
import club.usuarios.Usuario;

public class PruebaDeportesIndividuales {

    @BeforeEach
    void setUp() {
        Deporte.getDeportesRegistrados().clear();
        InscripcionAcademia.getInscripciones().clear();
        PartidoPractica.getPartidos().clear();
    }

    @Test void inscripcionIniciaConNivelPrincipianteYEloCero() {
        Socio socio = new Socio("socio@club.co", "clave");
        InscripcionAcademia inscripcion = InscripcionAcademia.inscribirSocio(socio, new Tenis());

        assertEquals(Nivel.PRINCIPIANTE, inscripcion.getNivel());
        assertEquals(0.0, inscripcion.getElo(), 0.00001);
    }
    @Test
    void permiteParticipantesDeNivelesAdyacentes() {
        Tenis tenis = new Tenis();
        Socio principiante = socioInscrito("principiante@club.co", tenis);
        Socio intermedio = socioInscrito("intermedio@club.co", tenis);
        InscripcionAcademia.buscar(intermedio, tenis).actualizarElo(30);

        PartidoPractica partido = new PartidoPractica(
                tenis, Modalidad.SENCILLOS, List.of(principiante, intermedio));

        assertEquals(2, partido.getParticipantes().size());
    }

    @Test
    void rechazaPrincipianteContraAvanzado() {
        Tenis tenis = new Tenis();
        Socio principiante = socioInscrito("principiante@club.co", tenis);
        Socio avanzado = socioInscrito("avanzado@club.co", tenis);
        InscripcionAcademia.buscar(avanzado, tenis).actualizarElo(90);

        assertThrows(IllegalArgumentException.class,
                () -> new PartidoPractica(
                        tenis, Modalidad.SENCILLOS, List.of(principiante, avanzado)));
    }

    @Test
    void permiteExcepcionDeEntrenadorJugador() {
        Tenis tenis = new Tenis();
        Socio avanzado = socioInscrito("avanzado@club.co", tenis);
        InscripcionAcademia.buscar(avanzado, tenis).actualizarElo(90);
        Entrenador entrenador = new Entrenador("entrenador-jugador@club.co", "clave");

        PartidoPractica partido = new PartidoPractica(tenis, Modalidad.SENCILLOS,
                List.<Usuario>of(entrenador, avanzado));

        assertTrue(partido.getParticipantes().contains(entrenador));
    }

    @Test
    void actualizaEloUnaSolaVezAlFinalizarPartido() {
        Tenis tenis = new Tenis();
        Socio ganador = socioInscrito("ganador@club.co", tenis);
        Socio perdedor = socioInscrito("perdedor@club.co", tenis);
        PartidoPractica partido = new PartidoPractica(
                tenis, Modalidad.SENCILLOS, List.of(ganador, perdedor));

        partido.finalizar(10, 5);

        assertEquals(15, InscripcionAcademia.buscar(ganador, tenis).getElo(), 0.00001);
        assertEquals(3, InscripcionAcademia.buscar(perdedor, tenis).getElo(), 0.00001);
        assertThrows(IllegalStateException.class, () -> partido.finalizar(10, 5));
        assertEquals(15, InscripcionAcademia.buscar(ganador, tenis).getElo(), 0.00001);
    }

    private Socio socioInscrito(String email, Tenis tenis) {
        Socio socio = new Socio(email, "clave");
        InscripcionAcademia.inscribirSocio(socio, tenis);
        return socio;
    }
}
