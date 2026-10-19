package club.usuarios;
import java.time.LocalDate;

public class Socio {

	private LocalDate fechaNacimiento;

	public Socio(String email, String constrasenia, LocalDate fechaNacimiento) {
		super();
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}


}
	