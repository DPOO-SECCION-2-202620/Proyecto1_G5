package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaEstadisticas {
    @Disabled("No existen EstadisticaFutbol ni Partido")
    @Test void futbolRegistraGolesAsistenciasYTarjetas() {
        // PENDIENTE: implementar estadísticas de fútbol.
    }
    @Disabled("No existe EstadisticaTenis")
    @Test void tenisPermiteSetsGamesAcesYErrores() {
        // PENDIENTE: implementar estadísticas de tenis.
    }
    @Disabled("No existe EstadisticaTenisDeMesa")
    @Test void tenisMesaPermiteSetsYPuntosTotales() {
        // PENDIENTE: implementar estadísticas de tenis de mesa.
    }
    @Disabled("No existen Partido ni registrarEstadistica")
    @Test void rechazaEstadisticaDeOtroDeporte() {
        // PENDIENTE: implementar la validación del deporte de la estadística.
    }
    @Disabled("Las suspensiones no tienen operaciones públicas")
    @Test void dosAmarillasSuspendenSiguienteEncuentro() {
        // PENDIENTE: implementar acumulación de amarillas y suspensión.
    }
    @Disabled("Las suspensiones no tienen operaciones públicas")
    @Test void tarjetaRojaSuspendeSiguienteEncuentro() {
        // PENDIENTE: implementar suspensión por tarjeta roja.
    }
}
