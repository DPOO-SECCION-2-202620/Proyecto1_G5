package Inscripciones;

import java.util.List;
import java.util.ArrayList;

import club.deportes.DeporteConjunto;
import club.deportes.Equipo;
import club.usuarios.Socio;

public class InscripcionEquipo {
	
	private String posicion;
	private int numeroCamiseta;
	private int numeroSuspenciones = 0;
	private int suspensionRestante = 0;
	private Socio socio; 
	private Equipo equipo;
	
	
	public void inscribirSocio(Socio socio, Equipo equipo, String posicion, int numeroCamiseta) {
		this.socio = socio;
		this.equipo = equipo;
		this.posicion = posicion;
		this.numeroCamiseta = numeroCamiseta;
	}
	
	public List<Equipo> consultarEquiposDisponibles(Socio socio, DeporteConjunto deoorte) {
	List<Equipo> equiposDisponibles = new ArrayList<Equipo>();
	
	for ()
	
	return equiposDisponibles;
	
	}
}
