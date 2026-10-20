package club.tienda;

public class UbicacionInvenatrio {
	
	//atributos
	private String id;
	private String nombre;

	
	//ctor
	public UbicacionInvenatrio(String id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	//metodos
	public String getNombre() {
		return nombre;
	}


	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getId() {
		return id;
	}

}
