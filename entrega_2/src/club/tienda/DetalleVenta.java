package club.tienda;

public class DetalleVenta {
	//atributos
	private int cantidad;
	private double precioUnitario;
	
	private Producto producto;

	//ctor
	public DetalleVenta(int cantidad, double precioUnitario, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.producto = producto;
	}
	
	//metodos
	public double getSubtotal() {
		return cantidad * precioUnitario;
	}

	
	

}
