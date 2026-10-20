package club.tienda;

public abstract class Producto {
	
	//atributos
	protected String nombre;
	protected String descripcion; 
	protected  double precio;
	
	//ctor
	public Producto(String nombre, String descripcion, double precio) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	//metodos

	public double getPrecio() {
		return precio;
	}

	public void actualizarPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	} 
	

	
	

	
	

}
