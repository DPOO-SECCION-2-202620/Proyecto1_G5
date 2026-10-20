package club.deportes;

import java.util.List;

public abstract class DeporteConjunto extends Deporte{
	//atributos
	private int cantidadJugadores;
	private List<? extends Enum<?>> posiciones;
	
	//ctor
	public DeporteConjunto(String nombre, int cantidadJugadores, List<? extends Enum<?>> posiciones) {
		
		super(nombre);
		this.cantidadJugadores = cantidadJugadores;
		this.posiciones = posiciones;
	}
	
	//metodos
	public int getMinimoJugadores() {
		
		return cantidadJugadores;
	}

	public List<? extends Enum<?>> getPosiciones() {
		return posiciones;
	}
	

}

	
