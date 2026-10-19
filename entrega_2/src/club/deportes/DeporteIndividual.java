package club.deportes;

import java.util.List;

public abstract class DeporteIndividual extends Deporte{
	
	//atributos
	private List<Modalidad> modalidades;
	
	//ctor 

	public DeporteIndividual(String nombre, List<Modalidad> modalidades) {
		super(nombre);
		this.modalidades = modalidades;
	}
	

}
