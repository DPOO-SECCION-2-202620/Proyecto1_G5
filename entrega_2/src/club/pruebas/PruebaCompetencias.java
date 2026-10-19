package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaCompetencias {
    @Disabled("No existen Competencia, ASCUN ni InscripcionCompetencia")
    @Test void permiteEquipoConNominaYCategoriaValidas() {
        // PENDIENTE: implementar la inscripción en competencias.
    }
    @Disabled("No existe el modelo de competencias ni categorías admitidas")
    @Test void rechazaEquipoConCategoriaIncompatible() {
        // PENDIENTE: implementar la validación de categoría.
    }
    @Disabled("No existen resultados de competencia ni tabla de posiciones")
    @Test void cerrosOrdenaTablaDePosiciones() {
        // PENDIENTE: implementar el cálculo y orden de la tabla.
    }
    @Disabled("No existe ASCUN ni el manejo de rondas")
    @Test void ascunGeneraEnfrentamientosDeEliminacion() {
        // PENDIENTE: implementar emparejamientos de eliminación.
    }
    @Disabled("No existen competencias, partidos oficiales ni rankings")
    @Test void rankingAcumulaEstadisticasPorCompetencia() {
        // PENDIENTE: implementar el ranking por competencia.
    }
}
