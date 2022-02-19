package mx.tecmilenio.computacion.java.evidencia.modelo;


import io.jsondb.annotation.Document;

import java.time.LocalDateTime;

@Document(collection = "citas", schemaVersion = "1.0")
public class Cita extends Registro {
    public LocalDateTime fechaHora;
    public Doctor doctor;
    public Paciente paciente;
    public String motivo;
}
