package mx.tecmilenio.computacion.java.evidencia.servicio;

import mx.tecmilenio.computacion.java.evidencia.ui.UI;

public class DB {
    private final static String db = "/db/db.json";

    public static void iniciar() {
        UI.encabezado("INICIALIZANDO DB");
    }
}
