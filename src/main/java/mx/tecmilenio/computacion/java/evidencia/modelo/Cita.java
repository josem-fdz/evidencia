package mx.tecmilenio.computacion.java.evidencia.modelo;


import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

import java.time.LocalDateTime;

@Document(collection = "citas", schemaVersion = "1.0")
public class Cita {
    public LocalDateTime fechaHora;
    public Doctor doctor;
    public Paciente paciente;
    public String motivo;

    @Id
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
