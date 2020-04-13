package comgroupid.demoartifact.Service;

import java.util.List;

import comgroupid.demoartifact.Modelo.Modelo;

public interface IDependenciaService {
    List<Modelo> obtenerModelos();
    Modelo buscarPorId(int idModelo);
    void GuardarModelo(Modelo modelo);
}