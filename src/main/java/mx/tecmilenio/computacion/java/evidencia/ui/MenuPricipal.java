package mx.tecmilenio.computacion.java.evidencia.ui;

class MenuPricipal implements Menu {
    @Override
    public String salida() {
        return "7";
    }

    @Override
    public void opciones() {
        UI.encabezado("Menu Principal");
        UI.opcion(1, "Alta Cita");
        UI.opcion(2, "Alta Doctor");
        UI.opcion(3, "Alta Pacientes");
        UI.opcion(4, "Lista Citas");
        UI.opcion(5, "Lista Doctores");
        UI.opcion(6, "Lista Pacientes");
        UI.opcion(7, "Salir");
        UI.lineas("-");
    }

    @Override
    public void procesar(String seleccion) {
        switch (seleccion) {

        }
    }
}
