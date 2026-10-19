package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaAdministracion {
    @Disabled("Equipo no dispone de una operación pública de desactivación")
    @Test void daDeBajaEquipo() {
        // PENDIENTE: implementar la baja administrativa de equipos.
    }

    @Disabled("Socio no dispone de una operación pública de baja")
    @Test void daDeBajaSocio() {
        // PENDIENTE: implementar la baja de socios y sus permisos.
    }

    @Disabled("No existen las clases Inventario ni Ubicacion")
    @Test void trasladaExistenciaEntreUbicacionesSinAlterarTotal() {
        // PENDIENTE: implementar inventario y traslado de existencias.
    }

    @Disabled("No existen las clases Inventario ni Ubicacion")
    @Test void rechazaTrasladoConStockInsuficiente() {
        // PENDIENTE: implementar el rechazo por stock insuficiente.
    }

    @Disabled("No existe la clase SugerenciaProducto")
    @Test void soloAdministradorApruebaSugerencias() {
        // PENDIENTE: implementar sugerencias y autorización administrativa.
    }

    @Disabled("No existen Turno ni SolicitudCambioTurno")
    @Test void cambioDeTurnoNoPuedeReducirCoberturaBajoDosEntrenadoresYUnFisio() {
        // PENDIENTE: implementar turnos y la regla mínima de cobertura.
    }

    @Disabled("No existen Turno ni SolicitudCambioTurno")
    @Test void cambioConCoberturaSuficienteSeAprueba() {
        // PENDIENTE: implementar la aprobación de cambios de turno.
    }
}
