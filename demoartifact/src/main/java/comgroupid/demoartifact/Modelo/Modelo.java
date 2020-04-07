package comgroupid.demoartifact.Modelo;

public class Modelo {
    private int     id = 0;
    private String  nombre = "";

    public Modelo(){
        id = -1;
        nombre  = "Mi nombre";
    }

    public Modelo(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Modelo [id=" + id + ", nombre=" + nombre + "]";
    }
}