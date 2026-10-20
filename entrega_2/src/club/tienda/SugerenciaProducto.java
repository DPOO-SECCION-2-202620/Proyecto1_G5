package club.tienda;

import club.personal.*;
import club.usuarios.*;

public abstract class SugerenciaProducto {
	
	//atributos
	private String nombre;
	private String descripcion;
	private TipoSugerencia tipo;
	private EstadoSugerencia estado;
	private Empleado solicitante;
	
	//ctor
	public SugerenciaProducto(String nombre, String descripcion, TipoSugerencia tipo, Empleado solicitante) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.estado = EstadoSugerencia.APROBADA;
		this.solicitante = solicitante;
	}


	//metodos
	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public EstadoSugerencia getEstado() {
		return estado;
	}

	public Empleado getSolicitante() {
		return solicitante;
	}
	
	public void aprobar(Administrador admin) {
		
	}
	
	public void noAprobar(Administrador admin) {
		
	}
	
	
	
	
	

}
