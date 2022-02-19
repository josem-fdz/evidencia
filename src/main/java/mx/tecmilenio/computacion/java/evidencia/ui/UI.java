package mx.tecmilenio.computacion.java.evidencia.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.System.out;
import static mx.tecmilenio.computacion.java.evidencia.util.Constantes.PATRON_DIGITOS;
import static mx.tecmilenio.computacion.java.evidencia.util.Constantes.lineas;
import static org.apache.commons.lang3.StringUtils.equalsIgnoreCase;

public class UI {
    public static void iniciar() {
        mostrar(new MenuLogin());

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

    public static void mostrar(Menu menu) {
        AtomicReference<String> seleccion = new AtomicReference<>();
        do {
            menu.opciones();
            seleccion.set(getDato("Seleccione una opcion", PATRON_DIGITOS));
            menu.procesar(seleccion.get());
        } while (!equalsIgnoreCase(seleccion.get(),
                menu.salida()));
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

    public static void opcion(String num, String in) {
        out.printf("| %s. %s\n", num, in);
    }
}
