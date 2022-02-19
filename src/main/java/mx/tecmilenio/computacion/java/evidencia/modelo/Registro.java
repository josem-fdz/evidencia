package mx.tecmilenio.computacion.java.evidencia.modelo;

import io.jsondb.annotation.Id;

abstract class Registro {
    @Id
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
