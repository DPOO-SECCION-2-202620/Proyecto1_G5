package club.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import club.Inscripciones.InscripcionEquipo;
import club.deportes.Categoria;
import club.deportes.Equipo;
import club.deportes.Futbol;
import club.usuarios.RepositorioUsuarios;
import club.usuarios.Socio;

public class PruebaInscripcionEquipos {
    private Equipo equipo;
    private Futbol futbol;
    private Socio socio;

    @BeforeEach
    void setUp() {
        Equipo.getEquiposDisponibles().clear();
        RepositorioUsuarios.getRepositorioUsuarios().clear();
        futbol = new Futbol();
        equipo = crearEquipo("Tigres", Categoria.SUB15, 20, futbol);
        socio = new Socio("socio@club.co", "clave");
        socio.setFechaNacimiento(LocalDate.now().minusYears(14));
    }

    @Test
    void equipoNuevoTieneCupos() {
        assertEquals(20, equipo.getCuposDisponibles());
    }

    @Test
    void rechazaEdadIncompatible() {
        assertFalse(equipo.getCategoria().admiteEdad(LocalDate.of(1990, 1, 1)));
    }

    @Test
    void equipoIniciaSinInscripciones() {
        assertTrue(equipo.getNomina().isEmpty());
    }

    @Test
    void consultaDisponibilidadCamisetaEnEquipoVacio() {
        assertTrue(equipo.getNomina().stream()
                .noneMatch(inscripcion -> inscripcion.getNumeroCamiseta() == 10));
    }

    @Test
    void inscribeSocioConEdadYCupo() {
        new InscripcionEquipo().inscribirSocio(
                socio, equipo, Futbol.Posicion.DELANTERO, 10);

        assertEquals(19, equipo.getCuposDisponibles());
        assertEquals(1, equipo.getNomina().size());
    }

    @Test
    void rechazaSegundoEquipoMismoDeporte() {
        Equipo segundoEquipo = crearEquipo("Leones", Categoria.SUB15, 20, new Futbol());
        new InscripcionEquipo().inscribirSocio(
                socio, equipo, Futbol.Posicion.DELANTERO, 10);

        assertThrows(IllegalStateException.class,
                () -> new InscripcionEquipo().inscribirSocio(
                        socio, segundoEquipo, Futbol.Posicion.PORTERO, 1));
    }

    @Test
    void rechazaEquipoSinCupos() {
        Equipo equipoLleno = crearEquipo("Lleno", Categoria.SUB15, 0, futbol);

        assertThrows(IllegalStateException.class,
                () -> new InscripcionEquipo().inscribirSocio(
                        socio, equipoLleno, Futbol.Posicion.DEFENSA, 4));
    }

    private Equipo crearEquipo(String nombre, Categoria categoria, int cupos, Futbol deporte) {
        return new Equipo(nombre, categoria, cupos, deporte) { };
    }
}
