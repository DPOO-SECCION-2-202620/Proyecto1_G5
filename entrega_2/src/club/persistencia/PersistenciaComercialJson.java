package club.persistencia;

import java.util.List;
import java.util.Map;

final class PersistenciaComercialJson {

	static final String ARCHIVO = "comercial.json";

	void cargar(List<Map<String, String>> registros) {
		if (!registros.isEmpty()) throw new PersistenciaException("Todavía no existen clases comerciales para reconstruir estos datos");
	}

	String serializar() {
		return "[]";
	}
}
