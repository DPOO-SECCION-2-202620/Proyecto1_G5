package club.usuarios;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import club.usuarios.Usuario;


public class RepositorioUsuarios {
	
	//atributos
	private Map<String,Usuario> usuarios;


	//ctor
	public RepositorioUsuarios(Map<String,Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	//metodos
	public Usuario buscarPorEmail(String email) {
		
		return usuarios.get(email);
	}
		
		
	}
	
	
	

}
