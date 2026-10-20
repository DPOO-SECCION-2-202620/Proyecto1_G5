package club.acceso;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

import club.Inscripciones.InscripcionAcademia;
import club.Inscripciones.InscripcionEquipo;
import club.competencias.Competencia;
import club.competencias.PartidoCompetencia;
import club.deportes.Deporte;
import club.deportes.DeporteConjunto;
import club.deportes.DeporteIndividual;
import club.deportes.Equipo;
import club.entrenamientos.SesionEntrenamiento;
import club.entrenamientos.EstadoAsistencia;
import club.entrenamientos.RegistroEntrenamiento;
import club.instalaciones.Instalacion;
import club.instalaciones.Reserva;
import club.partidos.EstadisticaJugador;
import club.partidos.Partido;
import club.partidos.PartidoInterno;
import club.partidos.PartidoPractica;
import club.personal.Entrenador;
import club.usuarios.*;

public class SesionActual {
	
	//atributos
	private Usuario usuarioActual = null;

	
	//ctor 
	public SesionActual(Usuario usuarioActual) {
		super();
		this.usuarioActual = usuarioActual;
	}
	
	//metodos
	public void cerrarSesion() {
		this.usuarioActual = null;
	}
	
	public Usuario getUsuarioActual() {
		return this.usuarioActual;
	}
	
	public void registrarFechaNacimiento(LocalDate fechaNacimiento) {
		obtenerSocio().setFechaNacimiento(fechaNacimiento);
	}

	public List<Equipo> consultarEquiposDisponibles(DeporteConjunto deporte) {
		return Equipo.getEquiposDisponiblesPorCategoria(obtenerSocio(), deporte);
	}

	public InscripcionEquipo inscribirEnEquipo(Equipo equipo, Enum<?> posicion, int numeroCamiseta) {
		InscripcionEquipo inscripcion = new InscripcionEquipo();
		inscripcion.inscribirSocio(obtenerSocio(), equipo, posicion, numeroCamiseta);
		return inscripcion;
	}

	public List<DeporteIndividual> consultarDeportesIndividualesDisponibles() {
		obtenerSocio();
		return DeporteIndividual.getDeportesIndividualesDisponibles();
	}

	public InscripcionAcademia inscribirEnDeporteIndividual(DeporteIndividual deporte) {
		return InscripcionAcademia.inscribirSocio(obtenerSocio(), deporte);
	}

	public Reserva reservarInstalacion(List<Socio> participantes, Instalacion instalacion,
			LocalDateTime fechaHora, Duration duracion, club.deportes.Modalidad modalidad) {
		Socio socio = obtenerSocio();
		if (participantes == null || participantes.isEmpty() || participantes.get(0) != socio) {
			throw new IllegalStateException("El socio autenticado debe ser el responsable");
		}
		return new Reserva(participantes, instalacion, fechaHora, duracion, modalidad);
	}

	public PartidoPractica programarPartidoPractica(DeporteIndividual deporte,
			club.deportes.Modalidad modalidad, List<Usuario> participantes) {
		validarSesionActiva();
		return new PartidoPractica(deporte, modalidad, participantes);
	}

	public SesionEntrenamiento programarSesionEntrenamiento(Deporte deporte,
			Instalacion instalacion, LocalDateTime fechaHora, Duration duracion) {
		return new SesionEntrenamiento(obtenerEntrenador(),
				deporte, instalacion, fechaHora, duracion);
	}

	public void convocarEquipo(SesionEntrenamiento sesion, Equipo equipo) {
		validarSesionActiva();
		sesion.convocarEquipo(this.usuarioActual, equipo);
	}

	public void convocarSocios(SesionEntrenamiento sesion, List<Socio> socios) {
		validarSesionActiva();
		sesion.convocarSocios(this.usuarioActual, socios);
	}

	public void eliminarConvocado(SesionEntrenamiento sesion, Socio socio) {
		validarSesionActiva();
		sesion.eliminarConvocado(this.usuarioActual, socio);
	}

	public RegistroEntrenamiento registrarEntrenamiento(SesionEntrenamiento sesion,
			Socio socio, EstadoAsistencia estado, Integer calificacion, String comentario) {
		validarSesionActiva();
		return sesion.registrarEntrenamiento(
				this.usuarioActual, socio, estado, calificacion, comentario);
	}

	public void registrarEstadistica(Partido partido, EstadisticaJugador estadistica) {
		partido.registrarEstadistica(obtenerEntrenador(), estadistica);
	}

	public List<EstadisticaJugador> consultarEstadisticas(Socio socio) {
		validarSesionActiva();
		return Partido.consultarEstadisticas(socio);
	}

	public List<EstadisticaJugador> consultarEstadisticas(Partido partido) {
		validarSesionActiva();
		return Partido.consultarEstadisticas(partido);
	}

	public void registrarResultado(PartidoCompetencia partido, int local, int visitante) {
		partido.registrarResultado(obtenerEntrenador(), local, visitante);
	}

	public void cumplirPartidoSuspension(Socio socio) {
		obtenerEntrenador();
		socio.cumplirPartidoSuspension();
	}

	public Socio registrarSocio(String email, String contrasenia) {
		return obtenerAdministrador().registrarSocio(email, contrasenia);
	}

	public LocalDate consultarFechaNacimiento(Socio socio) {
		return obtenerAdministrador().consultarFechaNacimiento(socio);
	}

	public void editarFechaNacimiento(Socio socio, LocalDate fechaNacimiento) {
		obtenerAdministrador().editarFechaNacimiento(socio, fechaNacimiento);
	}

	public void inscribirEquipoCompetencia(Competencia competencia, Equipo equipo) {
		obtenerAdministrador().inscribirEquipoCompetencia(competencia, equipo);
	}

	public PartidoCompetencia programarPartidoCompetencia(Competencia competencia,
			Equipo local, Equipo visitante, LocalDateTime fecha, Entrenador entrenador) {
		return obtenerAdministrador().programarPartidoCompetencia(
				competencia, local, visitante, fecha, entrenador);
	}

	public PartidoInterno programarPartidoInterno(Equipo local, Equipo visitante,
			LocalDateTime fecha, Entrenador entrenador) {
		return obtenerAdministrador().programarPartidoInterno(local, visitante, fecha, entrenador);
	}

	public boolean haySesionAtiva() {
		return this.usuarioActual != null;
	}

	public boolean haySesionActiva() {
		return haySesionAtiva();
	}

	private void validarSesionActiva() {
		if (!haySesionAtiva()) throw new IllegalStateException("No hay una sesión activa");
	}

	private Socio obtenerSocio() {
		validarSesionActiva();
		if (!(usuarioActual instanceof Socio)) throw new IllegalStateException("Se requiere un socio autenticado");
		return (Socio) usuarioActual;
	}

	private Entrenador obtenerEntrenador() {
		validarSesionActiva();
		if (!(usuarioActual instanceof Entrenador)) throw new IllegalStateException("Se requiere un entrenador autenticado");
		return (Entrenador) usuarioActual;
	}

	private Administrador obtenerAdministrador() {
		validarSesionActiva();
		if (!(usuarioActual instanceof Administrador)) throw new IllegalStateException("Se requiere un administrador autenticado");
		return (Administrador) usuarioActual;
	}
	

}
