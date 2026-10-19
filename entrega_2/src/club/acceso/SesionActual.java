package club.acceso;
import club.usuarios.*;

public class SesionActual {
	
	//atributos
	private Usuario usuarioActual = null;

	
	//ctor 
	public SesionActual(Usuario usuarioActual) {
		super();
		this.usuarioActual = usuarioActual;
	}
	
	//metodos
	public void cerrarSesion() {
		this.usuarioActual = null;
	}
	
	public Usuario getUsuarioActual() {
		return this.usuarioActual;
	}
	
	public boolean haySesionAtiva() {
		if (!this.usuarioActual.equals(null)) {
		return true;	
		}
		return false;
	}
	

}
