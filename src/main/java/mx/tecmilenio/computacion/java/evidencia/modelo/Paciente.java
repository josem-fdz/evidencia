package mx.tecmilenio.computacion.java.evidencia.modelo;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "pacientes", schemaVersion = "1.0")
public class Paciente extends Persona {
    @Id
    private int id;

    public Paciente() {
    }

    public Paciente(int id, String nombre) {
        this.id = id;
        setNombreCompleto(nombre);
    }

    @Override
    public String toString() {
        return String.format("id=%d\tnombre=%s", id, getNombreCompleto());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
