package club.pruebas;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class PruebaVentas {
    @Disabled("No existen VentaTienda, Articulo ni DetalleVenta")
    @Test void tiendaAplicaIvaDiecinuevePorCiento() {
        // PENDIENTE: assertEquals(119.0, venta.getTotal(), 0.01) para subtotal 100.
    }
    @Disabled("No existen ventas ni descuentos de empleados")
    @Test void empleadoTitularObtieneQuincePorCiento() {
        // PENDIENTE: implementar el descuento del 15 %.
    }
    @Disabled("No existen códigos de descuento ni ventas")
    @Test void socioConCodigoCompartidoObtieneOchoPorCiento() {
        // PENDIENTE: implementar el descuento del 8 % con código compartido.
    }
    @Disabled("No existen VentaCafeteria ni Snack")
    @Test void cafeteriaAplicaOchoPorCientoYPropinaEditable() {
        // PENDIENTE: implementar IVA de cafetería y propina editable.
    }
    @Disabled("No existen Snack ni aviso de alérgenos")
    @Test void snackExigeInformarAlergenosAntesDeComprar() {
        // PENDIENTE: implementar la confirmación del aviso de alérgenos.
    }
    @Disabled("No existen ventas ni instalaciones para validar el despacho")
    @Test void bloqueaBebidaCalienteEnPadelOTenisMesaTechado() {
        // PENDIENTE: implementar la restricción para bebidas calientes.
    }
    @Disabled("No existe un sistema de puntos de fidelidad")
    @Test void puntosEquivalenAlDosPorCientoDeLaVenta() {
        // PENDIENTE: implementar acumulación del 2 % en puntos.
    }
    @Disabled("No existe un sistema de puntos de fidelidad")
    @Test void rechazaRedimirMasPuntosQueSaldo() {
        // PENDIENTE: implementar validación del saldo al redimir.
    }
}
