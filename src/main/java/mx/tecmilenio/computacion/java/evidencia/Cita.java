package mx.tecmilenio.computacion.java.evidencia;

import java.time.LocalDateTime;

public class Cita extends Registro {
    public LocalDateTime fechaHora;
    public Doctor doctor;
    public Paciente paciente;
    public String motivo;
}
