package mx.tecmilenio.computacion.java.evidencia.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.out;

public class UI {
    static final int lineas = 80;
    static final String PATRON_DIGITOS = "\\d+";
    private static Scanner entrada = new Scanner(System.in);

    public static void iniciar() {
        mostrar(new MenuPricipal());
    }

    public static String getDato(String dato, String patron) {
        try {
            out.printf("\n%s: ", dato);
            return (new Scanner(System.in)).next(patron);
        } catch (InputMismatchException e) {
            out.println("Dato invalido!");
            return getDato(dato, patron);
        }
    }

    private static void mostrar(Menu menu) {
        AtomicReference<String> seleccion = new AtomicReference<>();
        do {
            menu.opciones();
            seleccion.set(getDato("Seleccione una opcion", PATRON_DIGITOS));
        } while (!seleccion.get().equals(menu.salida()));
    }

    public static void encabezado(String titulo) {
        out.println("\n");
        lineas("*");

        out.printf("| %s\n", titulo);

        lineas("*");

    }

    public static void lineas(String in) {
        out.println(in.repeat(lineas));
    }


}
