package club.pruebas;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import club.deportes.Categoria;

public class PruebaInscripcionEquipos {
    @Disabled("Equipo no expone los cupos disponibles")
    @Test
    void equipoNuevoTieneCupos() {
        // PENDIENTE: no existe Equipo.getCuposDisponibles().
        // assertEquals(20, equipo.getCuposDisponibles());
    }

    @Test
    void categoriaRechazaEdadIncompatible() {
        assertFalse(Categoria.SUB15.admiteEdad(LocalDate.of(1990, 1, 1)));
    }

    @Test
    void categoriaAceptaEdadCompatible() {
        assertTrue(Categoria.SUB15.admiteEdad(LocalDate.now().minusYears(14)));
    }

    @Disabled("Equipo no mantiene ni expone una nómina")
    @Test
    void equipoIniciaSinInscripciones() {
        // PENDIENTE: no existe Equipo.getNomina().
        // assertTrue(equipo.getNomina().isEmpty());
    }

    @Disabled("Equipo no implementa la consulta de números de camiseta")
    @Test
    void consultaDisponibilidadCamisetaEnEquipoVacio() {
        // PENDIENTE: no existe Equipo.numeroCamisetaDisponible(int).
        // assertTrue(equipo.numeroCamisetaDisponible(10));
    }

    @Disabled("La inscripción no valida edad ni cupo en la implementación actual")
    @Test
    void inscribeSocioConEdadYCupo() {
        // PENDIENTE: InscripcionEquipo solo asigna los datos recibidos.
    }

    @Disabled("No existe validación de una inscripción por deporte")
    @Test
    void rechazaSegundoEquipoMismoDeporte() {
        // PENDIENTE: no hay una operación que detecte inscripciones duplicadas.
    }

    @Disabled("La inscripción no comprueba los cupos del equipo")
    @Test
    void rechazaEquipoSinCupos() {
        // PENDIENTE: no existe validación de equipo lleno al inscribir.
    }
}
