package club.pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.time.LocalDate;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import club.Inscripciones.InscripcionEquipo;
import club.deportes.Categoria;
import club.deportes.Equipo;
import club.deportes.Futbol;
import club.persistencia.PersistenciaClubJson;
import club.persistencia.PersistenciaException;
import club.usuarios.RepositorioUsuarios;
import club.usuarios.Socio;

public class PruebaPersistencia {
	@TempDir
	Path directorioTemporal;

    @Test void guardarYRecargarConservaEstado() {
		PersistenciaClubJson persistencia = new PersistenciaClubJson(directorioTemporal.resolve("datos"));
		persistencia.cargarClub();
		Socio socio = new Socio("persistencia@club.co", "clave");
		socio.setFechaNacimiento(LocalDate.of(2000, 1, 1));
		Futbol futbol = new Futbol();
		Equipo equipo = new Equipo("Equipo persistido", Categoria.MAYORES, 10, futbol) { };
		new InscripcionEquipo().inscribirSocio(socio, equipo, Futbol.Posicion.DEFENSA, 4);
		persistencia.salvarClub();

		new PersistenciaClubJson(directorioTemporal.resolve("datos")).cargarClub();

		Socio recuperado = (Socio) RepositorioUsuarios.buscarPorEmail("persistencia@club.co");
		assertNotNull(recuperado);
		assertEquals(LocalDate.of(2000, 1, 1), recuperado.getFechaNacimiento());
		assertSame(recuperado, Equipo.getEquiposRegistrados().get("Equipo persistido")
				.getNomina().get(0).getSocio());
    }

    @Test void cargaIncompletaNoDejaEstadoParcial() {
		Path raiz = directorioTemporal.resolve("datos");
		PersistenciaClubJson persistencia = new PersistenciaClubJson(raiz);
		persistencia.cargarClub();
		Socio existente = new Socio("existente@club.co", "clave");
		persistencia.salvarClub();
		try {
			Files.delete(raiz.resolve("current/deportivo.json"));
		} catch (IOException e) {
			fail(e);
		}

		assertThrows(PersistenciaException.class, persistencia::cargarClub);
		assertSame(existente, RepositorioUsuarios.buscarPorEmail("existente@club.co"));
    }

    @Test void guardadoFallidoMantieneDirectorioAnterior() {
		Path raiz = directorioTemporal.resolve("datos");
		PersistenciaClubJson persistencia = new PersistenciaClubJson(raiz);
		persistencia.cargarClub();
		new Socio("confirmado@club.co", "clave");
		persistencia.salvarClub();
		Path usuarios = raiz.resolve("current/usuarios.json");
		String confirmado;
		try {
			confirmado = Files.readString(usuarios);
			Files.setPosixFilePermissions(directorioTemporal.resolve("datos"), Set.of(
					PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_EXECUTE));
			assertThrows(PersistenciaException.class, persistencia::salvarClub);
			assertEquals(confirmado, Files.readString(usuarios));
		} catch (IOException e) {
			fail(e);
		} finally {
			try {
				Files.setPosixFilePermissions(directorioTemporal.resolve("datos"), Set.of(
						PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE,
						PosixFilePermission.OWNER_EXECUTE));
			} catch (IOException e) {
				fail(e);
			}
		}
    }
}
