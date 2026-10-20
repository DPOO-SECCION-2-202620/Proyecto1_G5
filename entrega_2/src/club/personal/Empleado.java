package club.personal;

import club.usuarios.Usuario;

public abstract class Empleado extends Usuario {

	public Empleado(String email, String contrasenia) {
		super(email, contrasenia);
	}
}
