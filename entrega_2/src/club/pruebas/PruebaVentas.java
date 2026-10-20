package club.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import club.deportes.Modalidad;
import club.deportes.Padel;
import club.deportes.TenisDeMesa;
import club.instalaciones.Instalacion;
import club.personal.Entrenador;
import club.tienda.Articulo;
import club.tienda.Bebida;
import club.tienda.CodigoDescuento;
import club.tienda.DetalleVenta;
import club.tienda.GestorTienda;
import club.tienda.Inventario;
import club.tienda.Snack;
import club.tienda.UbicacionInventario;
import club.tienda.VentaCafeteria;
import club.tienda.VentaTienda;
import club.usuarios.Socio;

public class PruebaVentas {
	@Test void tiendaAplicaIvaDiecinuevePorCiento() {
		VentaTienda venta = ventaTienda(new Socio("iva@club.co", "clave"));
		assertEquals(119.0, venta.liquidar(), 0.01);
		assertEquals(19.0, venta.getImpuestos(), 0.01);
	}

	@Test void empleadoTitularObtieneQuincePorCiento() {
		Entrenador empleado = new Entrenador("empleado@club.co", "clave");
		VentaTienda venta = ventaTienda(empleado);
		assertEquals(15.0, venta.aplicarCodigo(new CodigoDescuento("EMP", empleado)), 0.01);
		assertEquals(101.15, venta.liquidar(), 0.01);
	}

	@Test void socioConCodigoCompartidoObtieneOchoPorCiento() {
		Entrenador empleado = new Entrenador("dueno@club.co", "clave");
		VentaTienda venta = ventaTienda(new Socio("socio-descuento@club.co", "clave"));
		assertEquals(8.0, venta.aplicarCodigo(new CodigoDescuento("COMPARTIDO", empleado)), 0.01);
	}

	@Test void cafeteriaAplicaOchoPorCientoYPropinaEditable() {
		VentaCafeteria venta = new VentaCafeteria(new Socio("cafe@club.co", "clave"));
		venta.agregarDetalle(new DetalleVenta(1, new Bebida("Café", "Caliente", 100, true)));
		venta.ajustarPropina(0.20);
		assertEquals(128.0, venta.liquidar(), 0.01);
		assertEquals(8.0, venta.getImpuestos(), 0.01);
		assertEquals(20.0, venta.getPropina(), 0.01);
	}

	@Test void snackExigeInformarAlergenosAntesDeComprar() {
		VentaCafeteria venta = new VentaCafeteria(new Socio("snack@club.co", "clave"));
		venta.agregarDetalle(new DetalleVenta(1, new Snack("Galleta", "Snack", 10, List.of("Gluten"))));
		assertThrows(IllegalStateException.class, venta::confirmar);
		assertEquals(List.of("Gluten"), venta.informarAlergenos());
		assertDoesNotThrow(venta::confirmar);
	}

	@Test void bloqueaBebidaCalienteEnPadelOTenisMesaTechado() {
		Instalacion cancha = new Instalacion("Pádel cafetería", new Padel(), List.of(Modalidad.DOBLES));
		VentaCafeteria venta = new VentaCafeteria(new Socio("bebida@club.co", "clave"), cancha);
		venta.agregarDetalle(new DetalleVenta(1, new Bebida("Tinto", "Caliente", 5, true)));
		assertThrows(IllegalStateException.class, venta::confirmar);
		assertFalse(venta.estaConfirmada());

		Instalacion mesaTechada = new Instalacion("Mesa techada", new TenisDeMesa(),
				List.of(Modalidad.SENCILLOS), true);
		VentaCafeteria segunda = new VentaCafeteria(
				new Socio("bebida-mesa@club.co", "clave"), mesaTechada);
		segunda.agregarDetalle(new DetalleVenta(1, new Bebida("Aromática", "Caliente", 5, true)));
		assertThrows(IllegalStateException.class, segunda::confirmar);
	}

	@Test void puntosEquivalenAlDosPorCientoDeLaVenta() {
		Socio socio = new Socio("puntos@club.co", "clave");
		VentaTienda venta = ventaTienda(socio);
		prepararGestor(venta).registrarVenta(venta);
		assertEquals(2, venta.getPuntosGanados());
		assertEquals(2, socio.getSaldoFidelidad().getPuntos());
	}

	@Test void rechazaRedimirMasPuntosQueSaldo() {
		Socio socio = new Socio("redimir@club.co", "clave");
		socio.getSaldoFidelidad().agregarPuntos(5);
		VentaTienda venta = ventaTienda(socio);
		venta.redimirPuntos(6);
		GestorTienda gestor = prepararGestor(venta);
		assertThrows(IllegalStateException.class, () -> gestor.registrarVenta(venta));
		assertEquals(5, socio.getSaldoFidelidad().getPuntos());
	}

	private VentaTienda ventaTienda(club.usuarios.Usuario comprador) {
		VentaTienda venta = new VentaTienda(comprador);
		venta.agregarDetalle(new DetalleVenta(1,
				new Articulo("Camiseta " + comprador.getEmail(), "Club", 100, "Ropa")));
		return venta;
	}

	private GestorTienda prepararGestor(VentaTienda venta) {
		GestorTienda gestor = new GestorTienda();
		Articulo articulo = (Articulo) venta.getDetalleVentas().get(0).getProducto();
		UbicacionInventario ubicacion = new UbicacionInventario("bodega", "Bodega");
		gestor.registrarProducto(articulo); gestor.registrarUbicacion(ubicacion);
		gestor.reabastecer(new Inventario(articulo, ubicacion, 0), 10);
		return gestor;
	}
}
