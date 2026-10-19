package club.deportes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import club.usuarios.Socio;

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
		
		Equipo.EquiposDisponibles.put(nombre, this);
	}


	//metodos
	public Map<String, Equipo> getEquiposDisponibles(){
		return EquiposDisponibles;
	}
	
	
	public List< Equipo> getEquiposDisponiblesPorCategoria(Socio socio, DeporteConjunto deporte){
		
		List<Equipo> EquiposEncontrados = new ArrayList<Equipo>();
		
		return EquiposEncontrados;
	}
	
	
	public void ocuparCupoEnEquipo(Equipo equipo) {
		this.cuposDisponibles -= 1;
		
		if (equipo.cuposDisponibles == 0) {
			EquiposDisponibles.remove(equipo);
		}
	}

	
	public void liberarCupoEnEquipo(Equipo equipo) {
		this.cuposDisponibles += 1;
		
		EquiposDisponibles.put(equipo.nombre, equipo);
	
	}
	
}
