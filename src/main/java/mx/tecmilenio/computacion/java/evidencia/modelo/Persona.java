package mx.tecmilenio.computacion.java.evidencia.modelo;

abstract class Persona extends Registro {
    private String nombreCompleto;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
