package mx.tecmilenio.computacion.java.evidencia.servicio;

import io.jsondb.JsonDBTemplate;
import mx.tecmilenio.computacion.java.evidencia.modelo.Usuario;
import mx.tecmilenio.computacion.java.evidencia.ui.UI;
import org.apache.commons.lang3.RandomStringUtils;

import static java.lang.System.out;

public class DB {
    private final static JsonDBTemplate db = new JsonDBTemplate(
            "/db",
            "mx.tecmilenio.computacion.java.evidencia.modelo");

    public static void iniciar() {
        UI.encabezado("INICIALIZANDO DB");
        Usuario usuario = new Usuario();
        usuario.setId("1");
        usuario.setUsuario("admin");
        usuario.setPassword(RandomStringUtils.randomAlphanumeric(4));

        out.printf(" Usuario 'admin' creado con contraseña: %s",
                usuario.getPassword());

        db.save(usuario, Usuario.class);

    }
}
