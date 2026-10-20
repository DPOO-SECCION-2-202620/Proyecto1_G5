package club.tienda;

public class Inventario {
	
	//atributos
	private Articulo artiuclo;
	private UbicacionInvenatrio ubicacion;
	private int cantidad;
	
	//ctor
	public Inventario(Articulo artiuclo, UbicacionInvenatrio ubicacion, int cantidad) {
		super();
		this.artiuclo = artiuclo;
		this.ubicacion = ubicacion;
		this.cantidad = cantidad;
	}
	
	//metodos
	public Articulo getArtiuclo() {
		return artiuclo;
	}

	public UbicacionInvenatrio getUbicacion() {
		return ubicacion;
	}

	public int consultarCantidad() {
		return cantidad;
	}
	
	public void descontar(int cantidad) {
		
		this.cantidad -= cantidad;
	}
	
	public void reabastecer(int cantidad) {
		
		this.cantidad += cantidad;
	}
	
	public void trasladar() {
		//TODO
	}
	
	
	
	
	

}
