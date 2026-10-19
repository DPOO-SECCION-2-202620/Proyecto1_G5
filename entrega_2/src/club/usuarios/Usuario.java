package club.usuarios;

public abstract class Usuario {
	private String email; 
	private String contrasenia;
	
	
	
	public String getEmail() {
		return email;
	} 
	
	public boolean isContrasenia(String contraseniaIngresada) {
		if(contrasenia.equals(contraseniaIngresada)) {
			return true; }else {return false;
		}
	}
	
	
}
