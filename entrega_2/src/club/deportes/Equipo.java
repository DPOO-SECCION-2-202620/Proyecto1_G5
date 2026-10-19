package club.deportes;

import java.util.HashMap;
import java.util.Map;

public abstract class Equipo {
	
	//Atributos
	private static final Map<String, Equipo> EquiposDisponibles = new HashMap<String,Equipo>();
	private String nombre;
	private Categoria categoria;
	private int cuposDisponibles;
	private int cupoMaximo;
	private boolean activo;
	
	private Deporte deporte;

	//ctor
	public Equipo(String nombre, Categoria categoria, int cupoMaximo, Deporte deporte) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.cupoMaximo = cupoMaximo;
		this.cuposDisponibles = cupoMaximo;
		this.activo = true;
		this.deporte = deporte;
	}


	//metodos
	public int getCuposDisponibles() {
		return cuposDisponibles;
	}

	public void setCuposDisponibles(int cuposDisponibles) {
		this.cuposDisponibles = cuposDisponibles;
	}
	
	
	
	
	
	
	
	
	

}
