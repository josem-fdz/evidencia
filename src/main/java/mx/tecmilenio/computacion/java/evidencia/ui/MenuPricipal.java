package mx.tecmilenio.computacion.java.evidencia.ui;

import static java.lang.System.out;

class MenuPricipal implements Menu {
    @Override
    public String salida() {
        return "4";
    }

    @Override
    public void opciones() {
        UI.encabezado("Menu Principal");
        out.println("| 1. Alta Pacientes");
        out.println("| 2. Alta Doctores");
        out.println("| 3. Alta Citas");
        out.println("| 4. Salir");
        UI.lineas("-");
    }
}
