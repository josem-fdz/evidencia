package mx.tecmilenio.computacion.java.evidencia.modelo;


import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "citas", schemaVersion = "1.0")
public class Cita {
    @Id
    private int id;
    private String fechaHora;
    private Doctor doctor;
    private Paciente paciente;
    private String motivo;

    public Cita() {
    }

    public Cita(int id, String fechaHora, Doctor doctor, Paciente paciente, String motivo) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.doctor = doctor;
        this.paciente = paciente;
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return String.format("id=%d, fechaHora='%s', doctor=%s, paciente=%s, motivo='%s'", id, fechaHora, doctor, paciente, motivo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
