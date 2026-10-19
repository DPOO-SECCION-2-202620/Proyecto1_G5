package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaDatosEnEquipo {
    @Disabled("InscripcionEquipo no expone camiseta ni posición y Equipo no controla dorsales")
    @Test void asignarCamisetaYPosicion() {
        // PENDIENTE: no existen getters ni numeroCamisetaDisponible(int).
    }
    @Disabled("No existe una operación pública para cambiar la camiseta")
    @Test void rechazarNumeroYaEnUso() {
        // PENDIENTE: implementar cambio y validación del número.
    }
    @Disabled("No existe catálogo de posiciones ni operación para cambiarlas")
    @Test void rechazarPosicionIncompatible() {
        // PENDIENTE: implementar validación de posiciones por deporte.
    }
}
