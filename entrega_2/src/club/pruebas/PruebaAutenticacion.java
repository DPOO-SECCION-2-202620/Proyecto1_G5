package club.pruebas;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import club.acceso.Autenticador;
import club.usuarios.RepositorioUsuarios;
import club.usuarios.Usuario;

public class PruebaAutenticacion {
    private Autenticador autenticador;

    @BeforeEach
    void setUp() {
        RepositorioUsuarios.getRepositorioUsuarios().clear();
        autenticador = new Autenticador();
    }

    @Test
    void usuarioInexistenteSeRechaza() {
        assertThrows(IllegalArgumentException.class,
                () -> autenticador.autenticar("no-existe@club.co", "clave"));
    }

    @Test
    void contrasenaCorrectaPermiteAutenticacion() {
        new Usuario("socio@club.co", "clave") { };
        assertDoesNotThrow(() -> autenticador.autenticar("socio@club.co", "clave"));
    }

    @Test
    void contrasenaIncorrectaSeRechaza() {
        new Usuario("socio@club.co", "clave-correcta") { };
        assertThrows(IllegalArgumentException.class,
                () -> autenticador.autenticar("socio@club.co", "clave-incorrecta"));
    }
}
