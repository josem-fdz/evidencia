package mx.tecmilenio.computacion.java.evidencia.modelo;

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "usuarios", schemaVersion = "1.0")
public class Usuario extends Persona implements Registro {

    @Id
    private int id;
    private String usuario;
    private String password;
    private Boolean esAdministrador = false;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String usuario, String password, Boolean esAdministrador) {
        this.usuario = usuario;
        this.password = password;
        this.esAdministrador = esAdministrador;
        this.id = id;
        this.setNombreCompleto(nombre);
    }

    @Override
    public String toString() {
        return String.format("id=%d\tusuario='%s'\tpassword='%s'\tesAdministrador=%s", id, usuario, password, esAdministrador);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean matches(String username, String passwd) {
        return username.equals(getUsuario()) && passwd.equals(getPassword());
    }
}
