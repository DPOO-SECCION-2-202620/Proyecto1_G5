package club.deportes;

import java.util.List;
import java.util.ArrayList;

public abstract class DeporteIndividual extends Deporte{
	
	//atributos
	private List<Modalidad> modalidades;
	
	//ctor 

	public DeporteIndividual(String nombre, List<Modalidad> modalidades) {
		super(nombre);
		this.modalidades = modalidades;
	}

	public List<Modalidad> getModalidades() {
		return modalidades;
	}

	public static List<DeporteIndividual> getDeportesIndividualesDisponibles() {
		List<DeporteIndividual> deportesIndividuales = new ArrayList<DeporteIndividual>();
		for (Deporte deporte : Deporte.getDeportesRegistrados().values()) {
			if (deporte instanceof DeporteIndividual) {
				deportesIndividuales.add((DeporteIndividual) deporte);
			}
		}
		return deportesIndividuales;
	}
	

}
