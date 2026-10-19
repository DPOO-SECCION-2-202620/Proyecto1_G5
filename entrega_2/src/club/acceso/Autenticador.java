package club.acceso;
import club.usuarios.*;

public class Autenticador {
	
	//atributos
	private RepositorioUsuarios repositorio;
	
	//ctor
	public Autenticador(RepositorioUsuarios repositorio) {
		this.repositorio = repositorio;
		
	}
	
	//metodos
	public Usuario autenticar(String email, String contrasenia) {
		//obtener usuario por email
		Usuario usuario = repositorio.buscarPorEmail(email);
		
		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}
		
		//verificar contrasenia
		if (!usuario.isContrasenia(contrasenia)) {
			throw new IllegalArgumentException("contrsasenia incorrecta");
		}
		
		return usuario;
	}
	

}
