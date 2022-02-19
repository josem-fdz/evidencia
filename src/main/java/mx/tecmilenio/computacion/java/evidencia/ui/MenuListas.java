package mx.tecmilenio.computacion.java.evidencia.ui;

import mx.tecmilenio.computacion.java.evidencia.persistencia.DB;

import static java.lang.System.out;

class MenuListas implements Menu {
    @Override
    public String salida() {
        return "4";
    }

    @Override
    public void opciones() {
        UI.encabezado("Lista de Registros");
        UI.opcion("1", "Pacientes");
        UI.opcion("2", "Doctores");
        UI.opcion("3", "Citas");
        UI.opcion("4", "Regresar");
        UI.lineas("-");

    }

    @Override
    public void procesar(String seleccion) {
        switch (seleccion) {
            case "1": {
                listaPacientes();
                break;
            }
            case "2": {
                listaDoctores();
                break;
            }
            case "3": {
                listaCitas();
                break;
            }
        }
    }

    private void listaPacientes() {
        UI.encabezado("Lista de Pacientes");

        DB.listaPaciente().forEach(out::println);
    }

    private void listaDoctores() {
        UI.encabezado("Lista de Doctores");

        DB.listaDoctor().forEach(out::println);
    }

    private void listaCitas() {
        UI.encabezado("Lista de Citas");

        DB.listaCita().forEach(out::println);
    }


}
