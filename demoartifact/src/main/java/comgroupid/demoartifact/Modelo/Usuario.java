package comgroupid.demoartifact.Modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String contrasena;
    private Date fechaRegistro;
    @OneToOne
    @JoinColumn(name="fkTipoUsuario")
    private TipoUsuario tipoUsuario;
    @OneToOne
    @JoinColumn(name="fkGenero")
    private Genero genero;
    private boolean estado;

    public Usuario(){
        this.estado = false;
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String correo, String contrasena, TipoUsuario tipoUsuario, Genero genero, boolean estado) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
        this.genero = genero;
        this.estado = estado;
    }

    public Usuario(String nombre, String primerApellido, String segundoApellido, String correo, String contrasena, Date fechaRegistro, TipoUsuario tipoUsuario, Genero genero, boolean estado) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.tipoUsuario = tipoUsuario;
        this.genero = genero;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario [contrasena=" + contrasena + ", correo=" + correo + ", estado=" + estado + ", fechaRegistro="
                + fechaRegistro + ", Genero=" + genero + ", TipoUsuario=" + tipoUsuario + ", idUsuario="
                + idUsuario + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido="
                + segundoApellido + "]";
    }
}