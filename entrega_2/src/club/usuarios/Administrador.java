package club.usuarios;

import java.time.LocalDate;
import java.time.LocalDateTime;

import club.competencias.Competencia;
import club.competencias.PartidoCompetencia;
import club.deportes.Equipo;
import club.partidos.PartidoInterno;
import club.personal.Entrenador;

public class Administrador extends Usuario {

	public Administrador(String email, String contrasenia) {
		super(email, contrasenia);
	}

	public Socio registrarSocio(String email, String contrasenia) {
		return new Socio(email, contrasenia);
	}

	public LocalDate consultarFechaNacimiento(Socio socio) {
		return socio.getFechaNacimiento();
	}

	public void editarFechaNacimiento(Socio socio, LocalDate fechaNacimiento) {
		socio.editarFechaNacimiento(fechaNacimiento);
	}

	public void inscribirEquipoCompetencia(Competencia competencia, Equipo equipo) {
		competencia.inscribirEquipo(this, equipo);
	}

	public PartidoCompetencia programarPartidoCompetencia(Competencia competencia,
			Equipo local, Equipo visitante, LocalDateTime fecha, Entrenador entrenador) {
		return new PartidoCompetencia(competencia, local, visitante, fecha, entrenador);
	}

	public PartidoInterno programarPartidoInterno(Equipo local, Equipo visitante,
			LocalDateTime fecha, Entrenador entrenador) {
		return new PartidoInterno(this, local, visitante, fecha, entrenador);
	}
}
