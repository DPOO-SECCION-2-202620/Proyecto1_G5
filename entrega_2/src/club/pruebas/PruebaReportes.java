package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaReportes {
    @Disabled("No existe una API de reportes administrativos")
    @Test void consultaReservasPartidosYSesionesSinModificarDatos() {
        // PENDIENTE: implementar consultas históricas sin efectos laterales.
    }
    @Disabled("No existen ventas, mensualidades ni reportes comerciales")
    @Test void consolidaVentasPorRubroYPeriodo() {
        // PENDIENTE: implementar consolidación por rubro y periodo.
    }
    @Disabled("No existen asistencia, resultados ni ranking histórico")
    @Test void reporteDeportivoIncluyeAsistenciaResultadosYRanking() {
        // PENDIENTE: implementar el reporte deportivo.
    }
    @Disabled("No existen roles administrativos ni autorización de reportes")
    @Test void usuarioNoAdministradorNoPuedeConsultarReportesPrivados() {
        // PENDIENTE: implementar restricciones de consulta.
    }
}
