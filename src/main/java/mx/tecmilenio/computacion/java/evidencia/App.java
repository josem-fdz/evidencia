package mx.tecmilenio.computacion.java.evidencia;

import mx.tecmilenio.computacion.java.evidencia.persistencia.DB;
import mx.tecmilenio.computacion.java.evidencia.ui.UI;

public class App {

    public static void main(String... args) {
        DB.iniciar();
        UI.iniciar();
    }
}
