package mx.tecmilenio.computacion.java.evidencia.modelo;


import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "doctores", schemaVersion = "1.0")
public class Doctor extends Persona {
    @Id
    private int id;

    public Doctor() {
    }

    public Doctor(int id, String nombre,
                  String especialidad) {
        this.id = id;
        setNombreCompleto(nombre);
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return String.format("id=%d\tnombre='%s'\tespecialidad='%s'", id, getNombreCompleto(), especialidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
