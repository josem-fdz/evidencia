package mx.tecmilenio.computacion.java.evidencia.ui;

import mx.tecmilenio.computacion.java.evidencia.modelo.Usuario;
import mx.tecmilenio.computacion.java.evidencia.persistencia.DB;
import mx.tecmilenio.computacion.java.evidencia.util.Constantes;

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

    }

    @Override
    public void procesar(String seleccion) {
        switch (seleccion) {
            case "1": {
                iniciarSesion();
                break;
            }
        }
    }

    private void iniciarSesion() {
        boolean inicioSesion = false;
        Usuario usuario = null;

        while (!inicioSesion) {
            var username = UI.getDato("Usuario",
                    Constantes.PATRON_ALFA_NUMERICO);

            var passwd = UI.getDato("Contraseña",
                    Constantes.PATRON_ALFA_NUMERICO);

            var db = DB.getUsuario(
                    username, passwd
            );

            inicioSesion = db.isPresent();

            if (inicioSesion) {
                usuario = db.get();
            } else {
                System.out.println("Usuario invalido!");
            }
        }

        UI.mostrar(new MenuPricipal(usuario.getEsAdministrador()));

    }
}
