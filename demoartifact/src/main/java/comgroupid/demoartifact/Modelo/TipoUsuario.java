package comgroupid.demoartifact.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoUsuario")
public class TipoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoUsuario;
    private String tipoUsuario;
    private String descripcion;
    private boolean estado;

    public TipoUsuario(){
        this.estado=false;
    }

    public TipoUsuario(String tipoUsuario, String descripcion, boolean estado){
        this.tipoUsuario = tipoUsuario;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoUsuario [descripcion=" + descripcion + ", estado=" + estado + ", id=" + idTipoUsuario + ", tipoUsuario="
                + tipoUsuario + "]";
    }
}