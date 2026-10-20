package club.tienda;

import club.personal.*;
import club.usuarios.Usuario;

public class CodigoDescuento {
	
	//atributos
	private String codigo;
	private Empleado propietario;
	
	private static final double DESCUENTO_PROPIO = 0.15;
	private static final double DESCUENTO_COMPARTIDO = 0.15;
	
	//ctor
	public CodigoDescuento(String codigo, Empleado propietario) {
		this.codigo = codigo;
		this.propietario = propietario;
	}


	//metodos
	public String getCodigo() {
		return codigo;
	}

	public Empleado getPropietario() {
		return propietario;
	}
	
	public double porcentajePara(Usuario comprador) {
		if(comprador.equals(this.getPropietario())) {
			return DESCUENTO_PROPIO;
		} else {
			
			return DESCUENTO_COMPARTIDO;
		}
		
	}
	
	

}
