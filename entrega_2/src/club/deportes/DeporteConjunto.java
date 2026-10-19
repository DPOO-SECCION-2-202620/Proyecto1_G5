package club.deportes;

public abstract class DeporteConjunto extends Deporte{
	//atributos
	private int cantidadJugadores;
	
	//ctor
	public DeporteConjunto(String nombre, int cantidadJugadores) {
		
		super(nombre);
		this.cantidadJugadores = cantidadJugadores;
	}
	
	//metodos
	public int getMinimoJugadores() {
		
		return cantidadJugadores;
	}
	
	}
	

}
