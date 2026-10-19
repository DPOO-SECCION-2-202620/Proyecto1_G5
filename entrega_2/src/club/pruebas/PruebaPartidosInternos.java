package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaPartidosInternos {
    @Disabled("Equipo no expone el cupo máximo configurado")
    @Test
    void equipoTieneCupoMaximoConfigurado() {
        // PENDIENTE: no existe Equipo.getCuposDisponibles() ni getCupoMaximo().
        // assertEquals(15, equipo.getCuposDisponibles());
    }

    @Disabled("No existe la clase PartidoInterno")
    @Test
    void partidoInternoExigeMismoDeporteYCategoria() {
        // PENDIENTE: implementar PartidoInterno y sus validaciones.
    }

    @Disabled("No existe PartidoInterno ni acceso a la nómina de Equipo")
    @Test
    void rechazaEquipoConNominaInsuficiente() {
        // PENDIENTE: validar los mínimos de jugadores según el deporte.
    }

    @Disabled("Equipo no valida el cupo máximo en su constructor")
    @Test
    void rechazaCupoMaximoInvalido() {
        // PENDIENTE: definir e implementar la restricción de cupo máximo.
    }
}
