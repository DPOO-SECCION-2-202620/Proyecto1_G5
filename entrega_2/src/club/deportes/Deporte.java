package club.deportes;

public abstract class Deporte {
	//atributos
	private String nombre; 
	
	//ctor
	public Deporte (String nombre) {
		this.nombre = nombre;
	}
	
	//metodos
	public String getNombre() {
		return nombre;
	}

}
