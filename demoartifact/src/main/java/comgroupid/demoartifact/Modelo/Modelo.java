package comgroupid.demoartifact.Modelo;

import java.util.Date;

public class Modelo {
    private int     id = 0;
    private String  nombre = "";
    private Date fecha = null;

    public Modelo(){
        id = -1;
        nombre  = "Mi nombre";
        fecha = new Date();
    }

    public Modelo(final int id, final String nombre, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Modelo [fecha=" + fecha + ", id=" + id + ", nombre=" + nombre + "]";
    }
}