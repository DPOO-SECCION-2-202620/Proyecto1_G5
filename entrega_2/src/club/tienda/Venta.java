package club.tienda;

import java.time.LocalDateTime;
import java.util.List;

import club.usuarios.*;

public abstract class Venta {
	
	//atributos
	protected LocalDateTime fecha;
	protected double subtotal;
	protected double impuestos;
	protected double descuentos;
	protected double total;
	protected int puntosGanados;
	protected int puntosRedimidos;
	
	protected List<DetalleVenta> detalleVentas;
	protected Usuario comprador;

	//ctor
	public Venta(LocalDateTime fecha, double subtotal, double impuestos, double descuentos, double total,
			int puntosGanados, int puntosRedimidos, Usuario comprador) {
		super();
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.impuestos = impuestos;
		this.descuentos = descuentos;
		this.total = total;
		this.puntosGanados = puntosGanados;
		this.puntosRedimidos = puntosRedimidos;
		this.comprador = comprador;
	}
	
	//metodos
	public double liquidar() {
		
	}
	
	public void redimirPuntos(int cantidad) {
		
	}
	
	public int asignarPuntos{
		
	}

	
	

}
