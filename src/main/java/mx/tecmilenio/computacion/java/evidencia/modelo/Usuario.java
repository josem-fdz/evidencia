package mx.tecmilenio.computacion.java.evidencia.modelo;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "usuarios", schemaVersion = "1.0")
public class Usuario extends Persona {
    private String usuario;
    private String password;
    private Boolean esAdministrador = false;

    @Id
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEsAdministrador() {
        return esAdministrador;
    }

    public void setEsAdministrador(Boolean esAdministrador) {
        this.esAdministrador = esAdministrador;
    }
}
