package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaReservas {
    @Disabled("No existen Reserva ni instalaciones deportivas")
    @Test void reservaValidaDevuelvePrimerSocioComoResponsable() {
        // PENDIENTE: implementar reservas, participantes y responsable.
    }
    @Disabled("No existen Reserva ni instalaciones deportivas")
    @Test void padelNoAceptaSencillos() {
        // PENDIENTE: implementar restricciones de modalidad para pádel.
    }
    @Disabled("No existe un repositorio de reservas")
    @Test void rechazaSuperposicionHoraria() {
        // PENDIENTE: implementar consulta y validación de ocupación.
    }
    @Disabled("No existen reservas ni límites simultáneos por disciplina")
    @Test void rechazaCupoSimultaneoAlcanzado() {
        // PENDIENTE: implementar el límite simultáneo de jugadores.
    }
}
