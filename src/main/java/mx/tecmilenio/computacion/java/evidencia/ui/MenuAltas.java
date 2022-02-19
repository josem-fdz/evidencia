package mx.tecmilenio.computacion.java.evidencia.ui;

import mx.tecmilenio.computacion.java.evidencia.persistencia.DB;

import static mx.tecmilenio.computacion.java.evidencia.util.Constantes.PATRON_ALFA_NUMERICO;
import static mx.tecmilenio.computacion.java.evidencia.util.Constantes.PATRON_DIGITOS;
import static org.apache.commons.lang3.math.NumberUtils.toInt;

class MenuAltas implements Menu {
    @Override
    public String salida() {
        return "4";
    }

    @Override
    public void opciones() {
        UI.encabezado("Altas");
        UI.opcion("1", "Pacientes");
        UI.opcion("2", "Medicos");
        UI.opcion("3", "Citas");
        UI.opcion("4", "Regresar");
        UI.lineas("-");

    }

    @Override
    public void procesar(String seleccion) {
        switch (seleccion) {
            case "1": {
                crearPaciente();
                break;
            }
            case "2": {
                crearDoctor();
                break;
            }
            case "3": {
                crearCita();
                break;
            }
        }
    }

    private void crearCita() {
        int id = toInt(UI.getDato("ID (numerico)", PATRON_DIGITOS));
        int idDoc = toInt(UI.getDato("ID Doctor (numerico)", PATRON_DIGITOS));
        int idPaciente = toInt(UI.getDato("ID Paciente(numerico)", PATRON_DIGITOS));
        var fecha = UI.getDato("Fecha", PATRON_ALFA_NUMERICO);
        var motivo = UI.getDato("Motivo", PATRON_ALFA_NUMERICO);

        DB.crearCita(id, fecha, idDoc, idPaciente, motivo);
    }

    private void crearPaciente() {

        int id = toInt(UI.getDato("ID (numerico)", PATRON_DIGITOS));
        var nombre = UI.getDato("Nombre", PATRON_ALFA_NUMERICO);

        DB.crearPaciente(id, nombre);
    }

    private void crearDoctor() {

        int id = toInt(UI.getDato("ID (numerico)", PATRON_DIGITOS));
        var nombre = UI.getDato("Nombre", PATRON_ALFA_NUMERICO);
        var especcialidad = UI.getDato("Especialidad", PATRON_ALFA_NUMERICO);

        DB.crearDoctor(id, nombre, especcialidad);
    }

}
