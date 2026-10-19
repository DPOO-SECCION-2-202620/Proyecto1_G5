package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaEntrenamiento {
    @Disabled("No existe la clase SesionEntrenamiento")
    @Test void sesionSeCreaConConvocadosYDuracion() {
        // PENDIENTE: implementar sesiones, convocados y duración.
    }
    @Disabled("No existen RegistroAsistencia ni RegistroEntrenamiento")
    @Test void registraAsistenciaYEvaluacionOpcional() {
        // PENDIENTE: implementar asistencia y evaluación.
    }
    @Disabled("No existe RegistroAsistencia")
    @Test void rechazaNotaFueraDeUnoACinco() {
        // PENDIENTE: implementar la validación de notas.
    }
    @Disabled("No existen convocatorias ni RegistroAsistencia")
    @Test void rechazaJugadorNoConvocado() {
        // PENDIENTE: implementar la validación de convocados.
    }
}
