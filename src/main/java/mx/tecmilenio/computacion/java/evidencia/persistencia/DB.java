package mx.tecmilenio.computacion.java.evidencia.persistencia;

import io.jsondb.JsonDBTemplate;
import mx.tecmilenio.computacion.java.evidencia.modelo.Cita;
import mx.tecmilenio.computacion.java.evidencia.modelo.Doctor;
import mx.tecmilenio.computacion.java.evidencia.modelo.Paciente;
import mx.tecmilenio.computacion.java.evidencia.modelo.Usuario;
import mx.tecmilenio.computacion.java.evidencia.ui.UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static mx.tecmilenio.computacion.java.evidencia.ui.UI.lineas;
import static mx.tecmilenio.computacion.java.evidencia.util.Constantes.tester;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class DB {
    private final static JsonDBTemplate db = new JsonDBTemplate(
            "/db",
            "mx.tecmilenio.computacion.java.evidencia.modelo");
    private static Logger logger = LoggerFactory.getLogger(DB.class);

    public static void iniciar() {
        iniciarPaciente();
        iniciarDoctor();
        iniciarUsuario();
    }

    static void iniciarUsuario() {
        UI.encabezado("Inicializando Base de Usuarios...");

        crearUsuario(1,
                tester.name().fullName(),
                "admin",
                randomNumeric(4),
                true);


        for (int i = 2; i < 4; i++) {
            crearUsuario(i,
                    tester.name().fullName(),
                    format("usr_%d", i),
                    randomNumeric(4),
                    false);
        }


        lineas("-");
    }

    private static void crearUsuario(int id, String nombre,
                                     String username,
                                     String passwd, boolean esAdmin) {

        Usuario usr = new Usuario(id, nombre, username, passwd, esAdmin);

        db.insert(usr);

        logger.info("Usuario creado: {}", usr);
    }

    static void iniciarPaciente() {
        UI.encabezado("Inicializando Base de Pacientes...");

        for (int i = 1; i < 4; i++) {
            crearPaciente(i, tester.name().fullName());
        }

        lineas("-");

    }

    public static void crearPaciente(int id, String nombre) {
        Paciente reg = new Paciente(id, nombre);

        db.insert(reg);

        logger.info("Paciente creado: {}", reg);

    }

    static void iniciarDoctor() {
        UI.encabezado("Inicializando Base de Doctores...");

        for (int i = 1; i < 4; i++) {
            crearDoctor(i, tester.name().fullName(), tester.educator().course());
        }
        lineas("-");

    }

    public static void crearDoctor(int id, String nombre, String especialidad) {
        Doctor reg = new Doctor(id, nombre, especialidad);

        db.insert(reg);

        logger.info("Doctor creado {}", reg);
    }

    public static void crearCita(int id, String fecha, int idDoc, int idPaciente, String motivo) {
        var doctor = listaDoctor().stream().filter(it -> it.getId() == idDoc).findFirst();

        if (doctor.isEmpty()) {
            logger.warn("Doctor {} no encontrado", idDoc);
            return;
        }

        var paciente = listaPaciente().stream().filter(it -> it.getId() == idPaciente).findFirst();

        if (paciente.isEmpty()) {
            logger.warn("Paciente {} no encontrado", idPaciente);
            return;
        }

        Cita cita = new Cita(id, fecha, doctor.get(), paciente.get(), motivo);

        db.insert(cita);

        logger.info("Cita creado {}", cita);
    }

    public static Optional<Usuario> getUsuario(String username, String passwd) {
        return listaUsuario().stream()
                .filter(it -> it.matches(username, passwd)).findFirst();
    }


    public static List<Usuario> listaUsuario() {
        return db.findAll(Usuario.class);
    }

    public static List<Cita> listaCita() {
        return db.findAll(Cita.class);
    }

    public static List<Paciente> listaPaciente() {
        return db.findAll(Paciente.class);
    }

    public static List<Doctor> listaDoctor() {
        return db.findAll(Doctor.class);
    }

}
