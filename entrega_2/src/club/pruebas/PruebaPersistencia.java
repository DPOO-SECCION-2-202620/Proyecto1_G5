package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaPersistencia {
    @Disabled("No existe una implementación de persistencia")
    @Test void guardarYRecargarConservaEstado() {
        // PENDIENTE: implementar guardado y carga del estado del club.
    }
    @Disabled("No existe una implementación de persistencia")
    @Test void cargaIncompletaNoDejaEstadoParcial() {
        // PENDIENTE: implementar carga atómica ante datos incompletos.
    }
    @Disabled("No existe una implementación de persistencia")
    @Test void guardadoFallidoMantieneDirectorioAnterior() {
        // PENDIENTE: implementar guardado atómico y recuperación ante fallos.
    }
}
