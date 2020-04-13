package comgroupid.demoartifact.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Date;

import org.springframework.stereotype.Service;

import comgroupid.demoartifact.Modelo.Modelo;

@Service
public class DependenciaServiceImpl implements IDependenciaService {
    private List<Modelo> lista = null;

    public DependenciaServiceImpl() {
        lista = new LinkedList<Modelo>();
        lista.add(new Modelo(1, "Aldo", new Date()));
        lista.add(new Modelo(2, "Daniel", new Date()));
        lista.add(new Modelo(3, "Mendoza", new Date()));
        lista.add(new Modelo(4, "Morales", new Date()));
    }

    @Override
    public List<Modelo> obtenerModelos() {
        return lista;
    }

    @Override
    public Modelo buscarPorId(int idModelo) {
        for (Modelo m : lista) {
            if (m.getId() == idModelo) {
                return m;
            }
        }
        return null;
    }

    @Override
    public void GuardarModelo(Modelo modelo) {
        lista.add(modelo);
    }
}