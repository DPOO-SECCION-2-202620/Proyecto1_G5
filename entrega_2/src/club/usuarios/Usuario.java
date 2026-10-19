package club.usuarios;

import club.usuarios.RepositorioUsuarios;



public abstract class Usuario {
	private String email; 
	private String contrasenia;
	
	
	
	
	public Usuario(String email, String contrasenia) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
		RepositorioUsuarios.anadirUsuarioARepo(this);;
	}

	public String getEmail() {
		return email;
	} 
	
	public boolean isContrasenia(String contraseniaIngresada) {
		if(contrasenia.equals(contraseniaIngresada)) {
			return true; }else {return false;
		}
	}
	
	
}
