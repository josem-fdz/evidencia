package mx.tecmilenio.computacion.java.evidencia.ui;

import static org.apache.commons.lang3.StringUtils.upperCase;

class MenuPricipal implements Menu {
    final boolean esAdministrador;

    MenuPricipal(boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }


    @Override
    public String salida() {
        return "3";
    }

    @Override
    public void opciones() {
        UI.encabezado("Menu Principal");
        if (esAdministrador) {
            UI.opcion("1", "Altas");
        }
        UI.opcion("2", "Listas");
        UI.opcion("3", "Salir");
        UI.lineas("-");
    }

    @Override
    public void procesar(String seleccion) {
        switch (upperCase(seleccion)) {
            case "1": {
                UI.mostrar(new MenuAltas());
                break;
            }
            case "2": {
                UI.mostrar(new MenuListas());
                break;
            }
        }
    }
}
