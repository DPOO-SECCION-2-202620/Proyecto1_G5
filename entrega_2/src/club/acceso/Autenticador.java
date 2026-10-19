package club.acceso;
import club.usuarios.*;

public class Autenticador {
	
	
	//metodos
	public void autenticar(String email, String contrasenia) {
		//obtener usuario por email
		Usuario usuario = RepositorioUsuarios.buscarPorEmail(email);
		
		//validar usuario existente
		if (usuario == null) {
			throw new IllegalArgumentException("El usuario no existe");
		}
			
		//validar contrasena
		if (!usuario.isContrasenia(contrasenia)) {
				throw new IllegalArgumentException("contrsasenia incorrecta");
					
		}
		
		//iniciar sesion actual
		new SesionActual(usuario);
	}

}
