package mx.tecmilenio.computacion.java.evidencia.modelo;


import io.jsondb.annotation.Document;

@Document(collection = "doctores", schemaVersion = "1.0")
public class Doctor extends Persona {
    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
