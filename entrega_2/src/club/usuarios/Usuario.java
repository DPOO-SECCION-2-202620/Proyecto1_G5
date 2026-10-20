package club.usuarios;

import club.usuarios.RepositorioUsuarios;



public abstract class Usuario {
	private String email; 
	private String contrasenia;
	private boolean activo;
	
	
	
	
	public Usuario(String email, String contrasenia) {
		super();
		this.email = email;
		this.contrasenia = contrasenia;
		this.activo = true;
		RepositorioUsuarios.anadirUsuarioARepo(this);;
	}

	public String getEmail() {
		return email;
	} 

	public String getContrasenia() {
		return contrasenia;
	}
	
	public boolean isContrasenia(String contraseniaIngresada) {
		if(contrasenia.equals(contraseniaIngresada)) {
			return true; }else {return false;
		}
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	
}
